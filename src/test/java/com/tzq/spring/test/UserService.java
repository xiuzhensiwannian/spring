package com.tzq.spring.test;

import cn.hutool.json.JSONUtil;
import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.factory.*;
import com.tzq.spring.context.ApplicationContext;
import com.tzq.spring.context.ApplicationContextAware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private String name;

    private String uId;

    private IUserDao userDao;

    private String company;

    private String location;

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;


    public UserService(String name) {
        this.name = name;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String queryUserInfo(String uid) {
        this.setName(userDao.queryUserName(uId));
        return JSONUtil.toJsonStr(this);
    }

    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }


    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("执行 setBeanFactory");
        this.beanFactory = beanFactory;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("执行 setApplicationContext");
        this.applicationContext = applicationContext;
    }

    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }
}
