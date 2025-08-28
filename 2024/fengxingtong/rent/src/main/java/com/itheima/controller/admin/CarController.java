package com.itheima.controller.admin;

import com.itheima.dto.CarDto;
import com.itheima.dto.CarPageQueryDto;
import com.itheima.result.PageResult;
import com.itheima.result.Result;
import com.itheima.service.CarService;
import com.itheima.vo.CarVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "车辆管理")
@RestController
@RequestMapping("/admin/car")
public class CarController {

    @Autowired
    private CarService carService;

    @ApiOperation("新增车辆")
    @PostMapping("/add")
    public Result add(@RequestBody CarDto carDto){
        carService.add(carDto);
        return Result.success();
}

@ApiOperation("删除车辆")
    @DeleteMapping("/delete")
    public Result delete(@RequestParam List<String> brands){
        carService.delete(brands);
        return Result.success();
    }


@ApiOperation("分页查询车辆信息")
    @GetMapping("/page")
    public Result<PageResult> page(CarPageQueryDto carPageQueryDto){
        PageResult pageResult = carService.page(carPageQueryDto);
        return Result.success(pageResult);
    }


@ApiOperation("查询车辆信息")
    @GetMapping("/{brand}")
    public Result<CarVo> getById(@PathVariable(value = "brand") String brand){
        CarVo carVo = carService.getById(brand);
        return Result.success(carVo);
    }


@ApiOperation("修改车辆信息")
    @PutMapping("/update")
    public Result update(@RequestBody CarDto carDto){
        carService.update(carDto);
        return Result.success();
    }

}







