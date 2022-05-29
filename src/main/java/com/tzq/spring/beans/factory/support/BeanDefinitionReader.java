package com.tzq.spring.beans.factory.support;

import com.tzq.spring.beans.BeansException;
import com.tzq.spring.core.io.Resource;
import com.tzq.spring.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
