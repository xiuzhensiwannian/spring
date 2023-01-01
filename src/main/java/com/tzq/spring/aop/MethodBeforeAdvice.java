package com.tzq.spring.aop;

import java.lang.reflect.Method;

public interface MethodBeforeAdvice {

    void befor(Method method, Object[] args, Object target) throws Throwable;
}
