package com.itheima.service;

import com.itheima.entity.Employee;

public interface EmployeeService {

    Employee findByEmployeename(String employeename);


    void register(String employeename, String pwd);


}
