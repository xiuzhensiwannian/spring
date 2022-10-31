package com.tzq.spring.beans.factory;

public interface BeanNameAware extends Aware {

    void setBeanName(String beanName);
}
