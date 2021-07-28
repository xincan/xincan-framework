package cn.com.xincan.xincanframework.config.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 1.0
 * @program xincan-goods
 * @description 切换数据源操作
 * @create 2020/7/31 16:59
 */
@Slf4j
@Aspect
@Component
public class DataSourceContextAop {

    /**
     *  数据库查询操作（从库选举，进行查询操作）
     *  针对数据库一主多从中【多从】的情况下，对其进行选举，找出其中合适的从数据库进行查询
     *  选举算法参见：cn.com.xincan.xincanframework.config.datasource.DataSourceContextHolder.java:68
     *
     * @author Jiangxincan
     * @date 2020/8/6 16:01
     */
    @Pointcut("!@annotation(cn.com.xincan.xincanframework.config.datasource.Master) " +
            "&& (execution(* cn.com.xincan.xincanframework.server.*.controller..*.select*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.get*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.find*(..))" +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.page*(..)))")
    public void readPointcut(){}

    /**
     *  数据库增、删、改作（主库操作）
     *
     * @author Jiangxincan
     * @date 2020/8/6 16:01
     */
    @Pointcut("@annotation(cn.com.xincan.xincanframework.config.datasource.Master) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.insert*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.add*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.save*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.put*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.update*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.edit*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.patch*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.remove*(..)) " +
            "|| execution(* cn.com.xincan.xincanframework.server.*.controller..*.delete*(..))")
    public void notReadPointcut(){}

    @Before("readPointcut()")
    public void read() {
        DataSourceContextHolder.slave();
    }

    @Before("notReadPointcut()")
    public void notRead() {
        DataSourceContextHolder.master();
    }

}
