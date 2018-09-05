package com.apm29.yjw.redis_demo.aspect;

import org.apache.logging.log4j.spi.LoggerContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggerContext.class);


    @Pointcut("execution(public * com.apm29.yjw.redis_demo.controller.*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)throws Throwable{
        //接收到请求,记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //log
        logger.info("URL:"+request.getRequestURL());
        logger.info("METHOD:"+request.getMethod());
        logger.info("IP:"+request.getRemoteAddr());

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String element = parameterNames.nextElement();
            logger.info("name:{},value:{}",element,request.getParameter(element));
        }
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfter(Object ret) throws Throwable{
        logger.info("RESPONSE:"+ret);
    }
}
