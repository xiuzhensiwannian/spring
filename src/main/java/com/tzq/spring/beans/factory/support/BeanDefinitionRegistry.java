package com.tzq.spring.beans.factory.support;

import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    String[] getBeanDefinitionNames();
}
