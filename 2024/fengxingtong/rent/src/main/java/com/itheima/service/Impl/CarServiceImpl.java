package com.itheima.service.Impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.CarDto;
import com.itheima.dto.CarPageQueryDto;
import com.itheima.entity.Car;
import com.itheima.mapper.CarMapper;
import com.itheima.result.PageResult;
import com.itheima.service.CarService;
import com.itheima.vo.CarVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public void add(CarDto carDto) {
        carMapper.add(carDto);
    }


    @Override
    public void delete(List<String> brands) {
        carMapper.delete(brands);
    }


    @Override
    public PageResult page(CarPageQueryDto carPageQueryDto) {
        PageHelper.startPage(carPageQueryDto.getPage(),carPageQueryDto.getPageSize());
        Page<CarVo> page = carMapper.page(carPageQueryDto);
        return new PageResult(page.getTotal(),page.getResult());
    }


    @Override
    public CarVo getById(String brand) {
        Car car = carMapper.getById(brand);
        CarVo carVo = new CarVo();
        BeanUtils.copyProperties(car,carVo);
        return carVo;
    }


    @Override
    public void update(CarDto carDto) {
        Car car = new Car();
        BeanUtils.copyProperties(carDto,car);
        carMapper.update(car);
    }


}
