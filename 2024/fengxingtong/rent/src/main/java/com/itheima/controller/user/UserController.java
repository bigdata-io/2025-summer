package com.itheima.controller.user;

import com.itheima.entity.LoginInfo;
import com.itheima.entity.User;
import com.itheima.result.Result;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/user")
@Validated
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result register(@Pattern(regexp="^\\S{6,16}$")String username, @Pattern(regexp="^\\S{6,16}$")String pwd)
    {
User u=userService.findByUsername(username);
    if(u==null)
    {
        userService.register(username,pwd);
        return Result.success();
    }
    else
    {
        return Result.error("用户已存在");
    }

    }


@ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@Pattern(regexp="^\\S{5,16}$")String username, @Pattern(regexp="^\\S{5,16}$")String pwd)
    {
        User loginUser=userService.findByUsername(username);

        if(loginUser==null)
        {
             return Result.error("用户名错误");
        }


        if(DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(loginUser.getPwd()))
        {
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",loginUser.getId());
        claims.put("username",loginUser.getUsername());
        String token= JwtUtil.generateToken(claims);

        LoginInfo loginInfo=new LoginInfo(loginUser.getId(), loginUser.getUsername(), loginUser.getStatus(),loginUser.getBalance(), token);
        return Result.success(loginInfo);
    }

            return Result.error("密码错误");
    }


@ApiOperation("用户登出")
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

}
