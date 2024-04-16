package com.example.demo.Common.CustomAnnotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());


    @Before("@annotation(com.example.demo.Common.CustomAnnotations.LogExecution)")
    public void logMethodStart(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("### start " + methodName + " ###");
    }

    @After("@annotation(com.example.demo.Common.CustomAnnotations.LogExecution)")
    public void logMethodEnd(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("### end " + methodName + " ###");
    }
}
