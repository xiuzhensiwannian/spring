package com.tzq.spring.test.annotation;

import com.tzq.spring.context.support.ClassPathXmlApplicationContext;
import com.tzq.spring.test.IUserService;
import org.junit.Test;


public class ApiTest {

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo("10001"));
    }

}
