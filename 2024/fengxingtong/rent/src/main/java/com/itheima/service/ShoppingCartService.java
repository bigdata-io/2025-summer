package com.itheima.service;

import com.itheima.dto.CarPageQueryDto;
import com.itheima.entity.Car;
import com.itheima.result.PageResult;

import java.util.List;

public interface ShoppingCartService {

    PageResult page(String username, CarPageQueryDto carPageQueryDto);

    void back(List<String> brands);

   List<String> getRentBrandByUsername(String username);


}
