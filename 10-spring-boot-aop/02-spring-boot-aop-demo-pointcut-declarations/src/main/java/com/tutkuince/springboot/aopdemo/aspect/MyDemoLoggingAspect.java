package com.tutkuince.springboot.aopdemo.aspect;

import com.tutkuince.springboot.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.tutkuince.springboot.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n======>>> Executing @Before advice on method()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object obj :
                args) {
            System.out.println(obj);
            if (obj instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) obj;
                System.out.println("Account Name: " + account.getName());
                System.out.println("Account Level: " + account.getLevel());
            }
        }
    }
}
