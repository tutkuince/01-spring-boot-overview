package com.tutkuince.springboot.aopdemo.aspect;

import com.tutkuince.springboot.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.tutkuince.springboot.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
        // print out method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @Around on method: " + method);
        // get begin timestamp
        long begin = System.currentTimeMillis();
        // now, let's execute the method
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception exc) {
            // log the exception
            System.out.println(exc.getMessage());
            // give user a custom message
            result = "Major accident! But no worries, your private AOP helicopter is on the way!";
        }
        // get end timestamp
        long end = System.currentTimeMillis();
        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n======>>> Duration: " + duration / 1000.0 + " seconds"); // milliseconds to seconds
        return result;
    }

    @After("execution(* com.tutkuince.springboot.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @After(finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.tutkuince.springboot.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "throwable"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable throwable) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterThrowing on method: " + method);
        // log the exception
        System.out.println("\n======>>> The Exception is : " + throwable);
    }

    // add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.tutkuince.springboot.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
        // print out the results of the method call
        System.out.println("\n======>>> Result is : " + result);

        // Let's post-process the data... let's modify it :->
        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account acct : result) {
            // get uppercase version of name
            String upperName = acct.getName().toUpperCase();
            // update the name on the account
            acct.setName(upperName);
        }
    }

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
