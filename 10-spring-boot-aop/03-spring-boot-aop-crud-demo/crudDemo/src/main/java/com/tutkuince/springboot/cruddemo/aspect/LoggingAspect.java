package com.tutkuince.springboot.cruddemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.tutkuince.springboot.cruddemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.tutkuince.springboot.cruddemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.tutkuince.springboot.cruddemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("===>>> in @Before: calling method" + method);

        // display the arguments to the method
        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop through and display args
        for (Object arg : args) {
            logger.info("===>>> argument: " + arg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===>>> in @AfterReturning: calling method" + method);

        // display data returned
        logger.info("===>>> result: " + result);
    }
}
