package com.itheima.service.Impl;


import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User u=userMapper.findByUsername(username);
        return u;
    }

    @Override
    public void register(String username, String pwd) {
        String md5pwd= DigestUtils.md5DigestAsHex(pwd.getBytes());
        userMapper.register(username,md5pwd);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
