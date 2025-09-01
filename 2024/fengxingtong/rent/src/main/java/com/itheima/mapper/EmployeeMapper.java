package com.itheima.mapper;

import com.itheima.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where employeename=#{employeename}")
    Employee findByEmployeename(String employeename);


    @Insert("insert into employee(employeename,pwd) values(#{employeename},#{md5pwd})")
    void register(String employeename, String md5pwd);


}
