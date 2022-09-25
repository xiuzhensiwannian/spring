package cn.tzq.spring.test.bean;

import cn.hutool.json.JSONUtil;
import com.tzq.spring.beans.factory.DisposableBean;
import com.tzq.spring.beans.factory.InitializingBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements InitializingBean, DisposableBean {

    private String name;

    private String uId;

    private UserDao userDao;

    private String company;

    private String location;


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

}
