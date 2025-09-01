package com.itheima.service.Impl;


import com.itheima.entity.Employee;
import com.itheima.mapper.EmployeeMapper;
import com.itheima.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee findByEmployeename(String employeename) {
        Employee e=employeeMapper.findByEmployeename(employeename);
        return e;
    }

    @Override
    public void register(String employeename, String pwd) {
        String md5pwd= DigestUtils.md5DigestAsHex(pwd.getBytes());
        employeeMapper.register(employeename,md5pwd);
    }


}
