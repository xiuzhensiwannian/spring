package com.tzq.spring.context;

import com.tzq.spring.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh() throws BeansException;
}
