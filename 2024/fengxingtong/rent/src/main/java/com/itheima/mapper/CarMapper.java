package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.dto.CarDto;
import com.itheima.dto.CarPageQueryDto;
import com.itheima.entity.Car;
import com.itheima.vo.CarVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarMapper {

    @Insert("insert into car(carname,brand,price,speed) values(#{carname},#{brand},#{price},#{speed})")
    void add(CarDto carDto);

    void delete(List<String> brands);

    Page<CarVo> page(CarPageQueryDto carPageQueryDto);

    @Select("select * from car where brand=#{brand}")
    Car getById(String brand);

    void update(Car car);


}
