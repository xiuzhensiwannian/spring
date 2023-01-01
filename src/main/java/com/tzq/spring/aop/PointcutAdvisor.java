package com.tzq.spring.aop;

public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();

}
