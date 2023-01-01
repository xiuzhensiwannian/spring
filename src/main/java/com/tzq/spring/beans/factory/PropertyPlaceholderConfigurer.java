package com.tzq.spring.beans.factory;

import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.PropertyValue;
import com.tzq.spring.beans.PropertyValues;
import com.tzq.spring.beans.factory.config.BeanDefinition;
import com.tzq.spring.beans.factory.config.BeanFactoryPostProcessor;
import com.tzq.spring.core.io.DefaultResourceLoader;
import com.tzq.spring.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {


    // 占位符前缀
    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    // 占位符后缀
    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        continue;
                    }
                    String strVal = (String)value;
                    StringBuilder sb = new StringBuilder(strVal);
                    int startIndex = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int endIndex = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
                        // 获取属性名称
                        String propKey = strVal.substring(startIndex + 2, endIndex);
                        // 从配置中获取属性值
                        String proValue = properties.getProperty(propKey);
                        sb.replace(startIndex, endIndex + 1, proValue);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), sb.toString()));
                    }

                }
            }
        } catch (IOException exception) {
            throw new BeansException("Could not load properties", exception);
        }
    }
}
