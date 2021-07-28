package cn.com.xincan.xincanframework.plugins.service;

import cn.com.xincan.xincanframework.plugins.exception.IdempotentException;
import cn.com.xincan.xincanframework.plugins.intercepor.IdempotentInterceptor;
import cn.com.xincan.xincanframework.utils.constant.IdempotentConstant;
import cn.com.xincan.xincanframework.utils.random.UUIDUtils;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 幂等性处理接口
 * @create 2020/7/20 15:56
 */
@Component
public class IdempotentService {

    Logger logger = LoggerFactory.getLogger(IdempotentService.class);

    private static final long EXPIRE_TIME = 30L;

    private final RedisService redisService;

    public IdempotentService(RedisService redisService) {
        this.redisService = redisService;
    }

    public String createToken() {
        String str = UUIDUtils.generateUUIDString();
        StringBuilder token = new StringBuilder();
        try {
            token.append(IdempotentConstant.TOKEN_PREFIX).append(str);
            redisService.setExpire(token.toString(), token.toString(),EXPIRE_TIME);
            boolean notEmpty = StringUtils.isEmpty(token.toString());
            if (!notEmpty) {
                return token.toString();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public boolean checkToken(HttpServletRequest request) {
        String token = request.getHeader(IdempotentConstant.TOKEN_NAME);
        // 请求头中不存在幂等性token
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(IdempotentConstant.TOKEN_NAME);
            // 参数列表中也不存在幂等性token
            if (StringUtils.isEmpty(token)) {
                logger.error("[{}] [{}] [{}]", ResponseCode.IDEMPOTENT_EXISTS_EXCEPTION.code(), ResponseCode.IDEMPOTENT_EXISTS_EXCEPTION.message());
                throw new IdempotentException(ResponseCode.IDEMPOTENT_EXISTS_EXCEPTION);
            }
        }
        // 判断redis中是否有token
        if (!redisService.exists(token)) {
            logger.error("[{}] [{}] [{}]", ResponseCode.IDEMPOTENT_REPETITION_OPERATION_EXCEPTION.code(), ResponseCode.IDEMPOTENT_REPETITION_OPERATION_EXCEPTION.message());
            throw new IdempotentException(ResponseCode.IDEMPOTENT_REPETITION_OPERATION_EXCEPTION);
        }
        // 移除redis的幂等性token
        boolean remove = redisService.remove(token);
        if (!remove) {
            logger.error("[{}] [{}] [{}]", ResponseCode.IDEMPOTENT_REPETITION_OPERATION_EXCEPTION.code(), ResponseCode.IDEMPOTENT_REPETITION_OPERATION_EXCEPTION.message());
            throw new IdempotentException(ResponseCode.IDEMPOTENT_REPETITION_OPERATION_EXCEPTION);
        }
        return true;
    }
}
