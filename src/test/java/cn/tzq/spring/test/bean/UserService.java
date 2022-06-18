package cn.tzq.spring.test.bean;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    private String name;

    private String uId;

    private UserDao userDao;

    private String company;

    private String location;


    public UserService(String name) {
        this.name = name;
    }

    public String queryUserInfo() {
        System.out.println("查询用户信息：" + name);
        return name;
    }

    public String queryUserInfo(String uid) {
        this.setName(userDao.queryUserName(uId));
        return JSONUtil.toJsonStr(this);
    }

}
