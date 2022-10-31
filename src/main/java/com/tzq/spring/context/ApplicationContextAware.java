package com.tzq.spring.context;

import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
