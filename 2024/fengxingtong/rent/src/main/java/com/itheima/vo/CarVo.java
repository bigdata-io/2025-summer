package com.itheima.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarVo {

    private Integer id;
    private String carname;
    private String brand;
    private Double price;
    private String speed;
}
