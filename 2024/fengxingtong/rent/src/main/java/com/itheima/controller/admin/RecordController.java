package com.itheima.controller.admin;

import com.itheima.entity.SaleRecord;
import com.itheima.result.Result;
import com.itheima.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "销售记录管理")
@RestController
@RequestMapping("/admin/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @ApiOperation("查询所有销售记录")
    @GetMapping("/get")
    public Result<List<SaleRecord>> get()
    {
        List<SaleRecord> records = recordService.get();
        return Result.success(records);
    }

}
