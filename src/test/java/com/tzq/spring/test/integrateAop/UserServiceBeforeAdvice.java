package com.tzq.spring.test.integrateAop;


import com.tzq.spring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class UserServiceBeforeAdvice implements MethodBeforeAdvice {


    @Override
    public void befor(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());

    }
}
