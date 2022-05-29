package cn.tzq.spring.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    private String name;

    private String uId;

    private UserDao userDao;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    public String queryUserInfo(String uid) {
        return userDao.queryUserName(uId);
    }

}
