package com.itheima.controller.admin;

import com.itheima.entity.Employee;
import com.itheima.result.Result;
import com.itheima.service.EmployeeService;
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
@RequestMapping("/admin/employee")
@Validated
@Api(tags = "员工管理")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

   @ApiOperation("员工注册")
    @PostMapping("/register")
    public Result register(@Pattern(regexp="^\\S{6,16}$")String employeename, @Pattern(regexp="^\\S{6,16}$")String pwd) {
        Employee u = employeeService.findByEmployeename(employeename);
        if (u == null) {
            employeeService.register(employeename, pwd);
            return Result.success();
        } else {
            return Result.error("用户已存在");
        }

    }

@ApiOperation("员工登录")
    @PostMapping("/login")
    public Result login(@Pattern(regexp="^\\S{5,16}$")String employeename, @Pattern(regexp="^\\S{5,16}$")String pwd)
    {
        Employee loginEmployee=employeeService.findByEmployeename(employeename);

        if(loginEmployee==null)
        {
            return Result.error("用户名错误");
        }

    if(DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(loginEmployee.getPwd()))
        {
            Map<String,Object> claims=new HashMap<>();
            claims.put("id",loginEmployee.getId());
            claims.put("employeename",loginEmployee.getEmployeename());
            String token= JwtUtil.generateToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }

@ApiOperation("员工登出")
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

}


