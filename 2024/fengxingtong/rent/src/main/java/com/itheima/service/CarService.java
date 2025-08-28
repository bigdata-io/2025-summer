package com.itheima.service;

import com.itheima.dto.CarDto;
import com.itheima.dto.CarPageQueryDto;
import com.itheima.result.PageResult;
import com.itheima.vo.CarVo;

import java.util.List;

public interface CarService {

    void add(CarDto carDto);

    void delete(List<String> brands);

    PageResult page(CarPageQueryDto carPageQueryDto);

    CarVo getById(String brand);

    void update(CarDto carDto);


}
