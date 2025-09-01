package com.itheima.service.Impl;

import com.itheima.entity.SaleRecord;
import com.itheima.mapper.RecordMapper;
import com.itheima.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<SaleRecord> get() {
        List<SaleRecord> records = recordMapper.get();
        return records;
    }

}
