package cn.tzq.spring.test;

import cn.hutool.json.JSONUtil;
import com.tzq.spring.beans.BeansException;
import com.tzq.spring.beans.factory.*;
import com.tzq.spring.context.ApplicationContext;
import com.tzq.spring.context.ApplicationContextAware;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private String name;

    private String uId;

    private UserDao userDao;

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

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("执行 setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("执行 setApplicationContext");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }
}
