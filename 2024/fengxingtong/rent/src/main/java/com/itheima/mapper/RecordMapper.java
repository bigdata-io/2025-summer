package com.itheima.mapper;

import com.itheima.entity.SaleRecord;
import com.itheima.vo.CarVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface RecordMapper {

@Select("select * from salerecord")
    List<SaleRecord> get();

    void add(LocalDateTime saletime, String username, List<CarVo> carVos);
}
