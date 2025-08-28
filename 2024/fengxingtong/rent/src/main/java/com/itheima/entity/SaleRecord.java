package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleRecord {
    private Integer id;
    private LocalDateTime saletime;
    private String username;
    private String brand;
    private Double amount;

}
