package com.itheima.controller.user;

import com.itheima.dto.CarPageQueryDto;
import com.itheima.entity.Car;
import com.itheima.entity.User;
import com.itheima.result.PageResult;
import com.itheima.result.Result;
import com.itheima.service.CarService;
import com.itheima.service.MallService;
import com.itheima.service.ShoppingCartService;
import com.itheima.service.UserService;
import com.itheima.utils.JwtUtil;
import com.itheima.vo.CarVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "用户商城管理")
@RestController
@RequestMapping("/user/mall")
public class MallController {

    @Autowired
    private CarService carService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private MallService mallService;

    @ApiOperation("分页查询车辆信息")
    @GetMapping("/page")
    public Result<PageResult> page(CarPageQueryDto carPageQueryDto){
        PageResult pageResult = carService.page(carPageQueryDto);
        return Result.success(pageResult);
    }

@ApiOperation("用户租车")
    @PostMapping("/rent")
    public Result rent(@RequestHeader("Authorization") String token,@RequestParam List<String> brands){
        String username = JwtUtil.getUsernameFromToken(token);

        if(brands == null || brands.size() == 0){
            return Result.error("尚未选择任何车辆！");
        }

        List<String> brandList =  shoppingCartService.getRentBrandByUsername(username);

        for (String brand : brandList) {
            if (brands.contains(brand)) {
                return Result.error("您已添加过此车辆！");
            }
        }

Double totalPrice = 0.0;
        for (String brand : brands) {
            Double price = carService.getById(brand).getPrice();
            totalPrice += price;
        }

User user = userService.getByUsername(username);

        if ((user.getStatus()==1&&user.getBalance() < totalPrice*0.7)||(user.getStatus()==0&&user.getBalance() < totalPrice))
            return Result.error("余额不足！");

        mallService.rent(username,brands);
return Result.success("支付成功");

    }


}
