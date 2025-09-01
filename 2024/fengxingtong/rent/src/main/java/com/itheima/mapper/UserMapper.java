package com.itheima.mapper;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Insert("insert into user(username,pwd) values(#{username},#{md5pwd})")
    void register(String username, String md5pwd);

@Select("select * from user where username= #{username}")
    User getByUsername(String username);

@Update("update user set balance=balance-#{totalPrice} where username=#{username}")
    void updateBalance(String username, Double totalPrice);
}
