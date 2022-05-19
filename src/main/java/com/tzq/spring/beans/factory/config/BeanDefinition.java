package com.tzq.spring.beans.factory.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

}
