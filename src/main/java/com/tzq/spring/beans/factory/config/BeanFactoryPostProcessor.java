package com.tzq.spring.beans.factory.config;

import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * 在所有的 BeanDefinition 加载完成后，实例化Bean
 * 对象之前，提供修改 BeanDefinition 属性的机制。
 */
public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
