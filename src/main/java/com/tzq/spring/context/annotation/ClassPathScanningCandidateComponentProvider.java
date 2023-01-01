package com.tzq.spring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.tzq.spring.beans.factory.config.BeanDefinition;
import com.tzq.spring.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classSet = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classSet) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
