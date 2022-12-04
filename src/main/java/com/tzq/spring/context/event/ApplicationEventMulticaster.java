package com.tzq.spring.context.event;

import com.tzq.spring.context.ApplicationEvent;
import com.tzq.spring.context.ApplicationListener;

public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent applicationEvent);

}
