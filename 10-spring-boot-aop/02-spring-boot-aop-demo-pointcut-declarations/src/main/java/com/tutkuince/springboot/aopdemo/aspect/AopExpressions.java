package com.tutkuince.springboot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.tutkuince.springboot.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.tutkuince.springboot.aopdemo.dao.*.get*(..))")
    public void getter() {}
    // create a pointcut for setter methods
    @Pointcut("execution(* com.tutkuince.springboot.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create pointcut: include package... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
