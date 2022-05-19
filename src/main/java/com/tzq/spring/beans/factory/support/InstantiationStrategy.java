package com.tzq.spring.beans.factory.support;

import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,
                       Object[] args) throws BeansException;

}
