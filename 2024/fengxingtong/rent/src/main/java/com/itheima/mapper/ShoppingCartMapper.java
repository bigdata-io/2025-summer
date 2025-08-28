package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.dto.CarPageQueryDto;
import com.itheima.entity.Car;
import com.itheima.vo.CarVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    Page<CarVo> page(CarPageQueryDto carPageQueryDto);

    void back(List<String> brands);



    @Select("select brand from shoppingcart where username=#{username}")
    List<String> getRentBrandByUsername(String username);


    void add(String username, List<CarVo> carVos);
}
