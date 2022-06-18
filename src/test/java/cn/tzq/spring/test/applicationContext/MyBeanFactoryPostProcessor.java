package cn.tzq.spring.test.applicationContext;


import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.PropertyValue;
import com.tzq.spring.beans.PropertyValues;
import com.tzq.spring.beans.factory.ConfigurableListableBeanFactory;
import com.tzq.spring.beans.factory.config.BeanDefinition;
import com.tzq.spring.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
