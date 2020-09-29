package cn.com.xincan.xincanframework.config.log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.UnknownHostException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * 操作日志记录切面类
 * @author WangMingShuai
 * @create 2019/12/20 15:27
 * @version 2.0.0
 * <author>                <time>                  <version>                   <description>
 * WangMingShuai         2019/12/20 15:27             2.0.0                         操作日志记录切面类
 */
@Component
@Slf4j
@Aspect
public class OptionLogAspect {

    /**
     * 菜单ID
     */
    private static final String MENU_ID = "menuId";
    /**
     * 操作ID
     */
    private static final String OPERATION_ID = "operationId";
    /**
     * 空值
     */
    private static final String NULL_VALUE = "-";
    /**
     * 客户端调用
     */
    private static final Integer SERVICE_FROM_CLIENT = 0;
    /**
     * 内部服务间调用
     */
    private static final Integer SERVICE_FROM_SERVICE = 1;

    /**
     * 获取微服务名称
     */
    @Value("${spring.application.name}")
    private String microService;

    /**
     * 获取微服务端口号
     */
    @Value("${server.port}")
    private Integer microServicePort;


    /**
     * 定义一个切入点
     */
    @Pointcut("@annotation(cn.com.xincan.xincanframework.config.log.OptionLog)")
    private void log() {
        //定义一个日志切入点
    }


    /**
     * 环绕触发 在所有标注@OptionLog的地方切入
     * @param joinPoint  切入点
     * @author WangMingShuai
     * @date 2020/1/7 10:14
     * @return java.lang.Object
     */
    @Around("log()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 返回信息
        Object object = joinPoint.proceed();
        // 拦截的方法参数类型
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            log.error("{}", "该注解只能用于方法");
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        // 拦截的实体类，就是当前正在执行的controller
        Object target = joinPoint.getTarget();
        // 获得被拦截的方法
        Method function = target.getClass().getMethod(
                joinPoint.getSignature().getName(),
                methodSignature.getMethod().getParameterTypes()
        );
        // 不需要拦截直接返回
        if (function == null) {
            return object;
        }
        // 判断扫描该函数是否包含自定义的log日志注解
        if (!function.isAnnotationPresent(OptionLog.class)) {
            return object;
        }
        save(function, joinPoint);
        return object;
    }

    /**
     * 处理BaseContextHandler取值为空的情况
     * @param value  值
     * @author YeMeng
     * @date 2020/3/25 10:42
     * @return java.lang.String
     */
    private String handleValue(String value) {
        return StringUtils.isEmpty(value) ? NULL_VALUE : value;
    }

    /**
     * 保存日志信息
     * @param function  被调用的方法
     * @param joinPoint  切入点
     * @author WangMingShuai
     * @date 2020/1/7 10:16
     * @return void
     */
    private void save(Method function, ProceedingJoinPoint joinPoint) throws UnknownHostException {
        // 获取自定义日志注解类
        OptionLog optionLog = function.getAnnotation(OptionLog.class);

        Annotation[][] parameterAnnotation = function.getParameterAnnotations();

        //获取斯瓦格ApiOperation注解类
        ApiOperation apiOperation = function.getAnnotation(ApiOperation.class);
        // 获取controller类中对应接口的路径
        String controllerUri = joinPoint.getSignature().getDeclaringTypeName();
        //获取request请求
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(sra).getRequest();
        // 获取请求头信息
        JSONObject headerParams = this.getHeaderParam(request);
        // 获取参数信息
        JSONObject classParam = getParameter(function, joinPoint.getArgs());
        // 获取说明信息
        String description = getDescription(optionLog, apiOperation,classParam, parameterAnnotation);
        System.out.println(description);

        // 实体封装
        SystemLogSaveDTO systemLogSaveDTO = SystemLogSaveDTO.builder()
//                .userId(handleValue(BaseContextHandler.getUserId()))
//                .name(handleValue(BaseContextHandler.getName()))
//                // 当前系统操作用户
//                .username(handleValue(BaseContextHandler.getUserName()))
//                // 租户
//                .tenantId(handleValue(BaseContextHandler.getTenantId()))
//                // 组织机构id
//                .organizationId(handleValue(BaseContextHandler.getOrganizationId()))
                // 获取远程访问者的IP地址
                .ip(getIpAddr(request))
                // 当前系统微服务端口号
                .port(microServicePort)
                // 当前系统微服务名称
                .microService(microService)
                // 当前系统类请求路径
                .classUrl(controllerUri + "." + joinPoint.getSignature().getName())
                // 当前系统类请求参数
                .classParam(classParam == null || classParam.size() == 0 ? null : classParam.toJSONString())
                // 当前系统操作类型（增删改查等等）
                .type(optionLog.type())
                // 当前系统操作说明
                .description(description)
                .build();

        if(headerParams.isEmpty()){
            systemLogSaveDTO.setMenuId(NULL_VALUE);
            systemLogSaveDTO.setOperationId(NULL_VALUE);
            systemLogSaveDTO.setServiceType(SERVICE_FROM_SERVICE);
        } else {
            String menuId = headerParams.getString(MENU_ID);
            String operationId = headerParams.getString(OPERATION_ID);
            if(!StringUtils.isEmpty(menuId)){
                systemLogSaveDTO.setMenuId(menuId);
            }
            if(!StringUtils.isEmpty(operationId)){
                systemLogSaveDTO.setOperationId(operationId);
            }
            systemLogSaveDTO.setServiceType(SERVICE_FROM_CLIENT);
        }

        log.info("{}：[{}]","保存日志信息",description);


    }

    /**
     *  获取日志说明信息
     * @param optionLog  自定义日志注解对象
     * @param apiOperation 斯瓦格内部注解对象
     * @param jsonObject 操作参数对象
     * @param annotations 操作参数对象上的注解
     * @author JiangXincan
     * @date 2020/9/23 16:56
     * @return java.lang.String
     */
    private String getDescription(OptionLog optionLog, ApiOperation apiOperation, JSONObject jsonObject, Annotation[][] annotations) {
       StringBuilder stringBuilder = new StringBuilder(optionLog.type() + ":");
       if(StringUtils.isEmpty(optionLog.description())) {
           if (!StringUtils.isEmpty(apiOperation.notes())) {
               stringBuilder.append(apiOperation.notes());
           }else{
               stringBuilder.append(apiOperation.value());
           }
       }else {
           stringBuilder.append(optionLog.description());
       }

       if(!ObjectUtils.isEmpty(jsonObject)){
            for(Object object : jsonObject.keySet()) {
                try {
                    JSONObject json = JSONObject.parseObject(JSON.toJSONString(jsonObject.get(object)));
                    Class<?> clazz = jsonObject.get(object).getClass();
                    for(Object obj : json.keySet()) {
                        Field field;
                        try {
                            field = clazz.getDeclaredField(obj.toString());
                        }catch (Exception e) {
                            field = clazz.getSuperclass().getDeclaredField(obj.toString());
                        }
                        ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
                        stringBuilder.append(",").append(optionLog.type()).append(apiModelProperty.value()).append("为:").append(json.get(obj).toString());
                    }
                } catch (Exception e) {
                    String value = getAnnotationValue(annotations, object);
                    stringBuilder.append(",").append(optionLog.type()).append(value).append("为:").append(jsonObject.get(object).toString());
                }
            }
       }
       return stringBuilder.toString();
    }

    /**
     *  获取拦截的方法上的参数
     * @param method  方法对象
     * @param args 方法参数列表
     * @author JiangXincan
     * @date 2020/9/23 16:50
     * @return com.alibaba.fastjson.JSONObject
     */
    private JSONObject getParameter(Method method, Object[] args) {
        Parameter[] parameters = method.getParameters();
        Annotation[][] parameterAnnotations =  method.getParameterAnnotations();
        int count = parameters.length;
        if(count == 0 || ObjectUtils.isEmpty(args) || args.length == 0){
            return null;
        }
        JSONObject json = new JSONObject();
        for (int i = 0; i < count; i++) {
            // 处理request,response请求
            if(args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse){
                continue;
            }
            // 处理单个文件上传
            if(args[i] instanceof MultipartFile){
                String name = getAnnotationName(parameterAnnotations);
                json.put(StringUtils.isEmpty(name) ? "file" : name, ((MultipartFile) args[i]).getOriginalFilename());
                continue;
            }
            // 处理多个文件上传
            if (args[i] instanceof MultipartFile[]) {
                String name = getAnnotationName(parameterAnnotations);
                StringBuilder fileNames = new StringBuilder();
                for(MultipartFile file : (MultipartFile[]) args[i]){
                    fileNames.append(",").append(file.getOriginalFilename());
                }
                json.put(StringUtils.isEmpty(name) ? "file" : name, fileNames.toString().substring(1));
                continue;
            }
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            //将PathVariable注解修饰的参数作为请求参数
            PathVariable pathVariable = parameters[i].getAnnotation(PathVariable.class);
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (!ObjectUtils.isEmpty(requestBody)) {
                json.put(args[i].getClass().getSimpleName(), args[i]);
            }else if (!ObjectUtils.isEmpty(pathVariable)) {
                json.put(pathVariable.name(), args[i]);
            }else if(!ObjectUtils.isEmpty(requestParam)) {
                json.put(requestParam.name(), args[i]);
            }else {
                json.put(args[i].getClass().getSimpleName(), args[i]);
            }
        }
        return json;

    }

    /**
     *  获取斯瓦格参数注解的name值
     * @param parameterAnnotations 参数列表注解二维注解数组
     * @author JiangXincan
     * @date 2020/9/27 15:39
     * @return java.lang.String
     */
    private String getAnnotationName(Annotation[][] parameterAnnotations) {
        String name = null;
        for (Annotation[] annotations : parameterAnnotations) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof ApiParam) {
                    name = ((ApiParam) annotation).name();
                    break;
                }
            }
        }
        return name;
    }

    /**
     *  根据参数列表上的注解，获取斯瓦格参数注解的value值
     * @param annotations  指定参数注解二维注解数组
     * @param object 指定参数对象
     * @author JiangXincan
     * @date 2020/9/27 15:35
     * @return java.lang.String
     */
    private String getAnnotationValue(Annotation[][] annotations, Object object) {
        String value = null;
        for (Annotation[] annotation : annotations) {
            for (Annotation ann : annotation) {
                if (ann instanceof ApiParam) {
                    if (((ApiParam) ann).name().equals(object.toString())) {
                        value = ((ApiParam) ann).value();
                        break;
                    }
                }
            }
        }
        return value;
    }

    /**
     *  获取header头部信息
     *  menuId 菜单ID
     *  operationId 操作ID
     * @author JiangXincan
     * @date 2020/3/23 19:57
     * @return com.alibaba.fastjson.JSONObject
     */
    private JSONObject getHeaderParam(HttpServletRequest request){
        JSONObject ids = new JSONObject();
        String menuId = request.getHeader(MENU_ID);
        String operationId = request.getHeader(OPERATION_ID);
        if(!StringUtils.isEmpty(menuId)){
            ids.put(MENU_ID, menuId);
        }
        if(!StringUtils.isEmpty(operationId)){
            ids.put(OPERATION_ID, operationId);
        }
        return ids;

    }

    /**
     *  获取登录用户的IP地址
     * @param request  请求
     * @author WangMingShuai
     * @date 2020/4/10 9:09
     * @return java.lang.String
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
