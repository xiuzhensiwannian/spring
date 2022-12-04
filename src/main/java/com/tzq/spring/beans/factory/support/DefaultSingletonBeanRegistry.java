package com.tzq.spring.beans.factory.support;

import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.factory.DisposableBean;
import com.tzq.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     */
    protected static final Object NULL_OBJECT = new Object();

    private Map<String, Object> singletonObjectMap = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new LinkedHashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjectMap.get(beanName);
    }

    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjectMap.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

}
