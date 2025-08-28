package com.itheima.service;

import com.itheima.entity.User;

public interface UserService {

    User findByUsername(String username);

    void register(String username, String pwd);


    User getByUsername(String username);
}
