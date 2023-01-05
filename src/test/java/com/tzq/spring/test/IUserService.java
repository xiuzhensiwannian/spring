package com.tzq.spring.test;

public interface IUserService {

    String queryUserInfo();

    String queryUserInfo(String uid);

    String register(String userName);

}
