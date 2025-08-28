package com.itheima.controller.user;

import com.itheima.dto.CarPageQueryDto;
import com.itheima.result.PageResult;
import com.itheima.result.Result;
import com.itheima.service.ShoppingCartService;
import com.itheima.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户车库管理")
@RestController
@RequestMapping("/user/garage")
public class GarageController {

@Autowired
private ShoppingCartService shoppingCartService;

    @GetMapping("/page")
    @ApiOperation("分页查询用户车库")
    public Result<PageResult> page(@RequestHeader("Authorization") String token, CarPageQueryDto carPageQueryDto){
       String username = JwtUtil.getUsernameFromToken(token);
        PageResult pageResult = shoppingCartService.page(username, carPageQueryDto);
        if(pageResult.getTotal() != 0)
        return Result.success(pageResult);
        else
            return Result.error("您的车库空空如也！");
    }

@ApiOperation("用户归还车辆")
    @DeleteMapping("/back")
    public Result back(@RequestParam List<String> brands){
        shoppingCartService.back(brands);
        return Result.success();
    }

}
