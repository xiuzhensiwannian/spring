package com.tzq.spring.beans.factory;

import com.tzq.spring.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name, Object... args) throws BeansException;
}
