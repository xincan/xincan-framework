package cn.com.xincan.xincanframework.plugins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description Redis操作工具类
 * @author JiangXincan
 * @create 2021/7/26 19:43
 * @version 2.0.0
 */
@Component
public class RedisService {

    private final RedisTemplate<Object, Object> redisTemplate;

    public RedisService(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 写入缓存
     * @param key  redis写入key值
     * @param value redis写入对应的值
     * @author JiangXincan
     * @date 2021/7/27 10:13
     * @return boolean
     **/
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 写入缓存设置时效时间
     * @param key  redis写入key值
     * @param value redis写入对应的值
     * @param expireTime 失效时间
     * @author JiangXincan
     * @date 2021/7/27 10:13
     * @return boolean
     **/
    public boolean setExpire(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 判断key是否存在key
     * @param key redis key
     * @author JiangXincan
     * @date 2021/7/27 10:14
     * @return boolean
     **/
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据key值读取value
     * @param key redis key
     * @author JiangXincan
     * @date 2021/7/27 10:15
     * @return java.lang.Object
     **/
    public Object get(final String key) {
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 删除 key 对应的人
     * @param key redis key
     * @author JiangXincan
     * @date 2021/7/26 20:10
     * @return boolean
     **/
    public boolean remove(final String key) {
        if (exists(key)) {
            return redisTemplate.delete(key);
        }
        return false;
    }

}
