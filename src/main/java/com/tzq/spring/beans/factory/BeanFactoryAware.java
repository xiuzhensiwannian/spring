package com.tzq.spring.beans.factory;

import com.tzq.spring.beans.BeansException;

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
