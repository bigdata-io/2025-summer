package com.itheima.service.Impl;

import com.itheima.mapper.RecordMapper;
import com.itheima.mapper.ShoppingCartMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.service.CarService;
import com.itheima.service.MallService;
import com.itheima.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MallServiceImpl implements MallService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CarService carService;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private RecordMapper recordMapper;

    public MallServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void rent(String username, List<String> brands) {
        Double totalPrice = 0.0;
        List<CarVo> carVos = new ArrayList<>();
        for (String brand : brands) {
            CarVo carVo = carService.getById(brand);
            carVos.add(carVo);
            Double price = carVo.getPrice();
            totalPrice += price;
        }
        userMapper.updateBalance(username,totalPrice);
        shoppingCartMapper.add(username,carVos);
        LocalDateTime saletime = LocalDateTime.now();
        recordMapper.add(saletime,username,carVos);
    }
}
