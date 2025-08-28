package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.CarPageQueryDto;
import com.itheima.entity.Car;
import com.itheima.mapper.ShoppingCartMapper;
import com.itheima.result.PageResult;
import com.itheima.service.ShoppingCartService;
import com.itheima.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public PageResult page(String username, CarPageQueryDto carPageQueryDto) {
        PageHelper.startPage(carPageQueryDto.getPage(),carPageQueryDto.getPageSize());

        carPageQueryDto.setUsername(username);

        Page<CarVo> page = shoppingCartMapper.page(carPageQueryDto);
        return new PageResult(page.getTotal(),page.getResult());
    }


    @Override
    public void back(List<String> brands) {
        shoppingCartMapper.back(brands);
    }


    @Override
    public List<String> getRentBrandByUsername(String username) {
        return shoppingCartMapper.getRentBrandByUsername(username);
    }



}
