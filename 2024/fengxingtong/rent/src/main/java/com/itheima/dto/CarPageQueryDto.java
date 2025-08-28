package com.itheima.dto;

import lombok.Data;

@Data
public class CarPageQueryDto {

    private Integer page;
    private Integer pageSize;
    private String brand;
    private String username;
}
