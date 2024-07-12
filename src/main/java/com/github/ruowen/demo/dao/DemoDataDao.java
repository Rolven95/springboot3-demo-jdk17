package com.github.ruowen.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.ruowen.demo.dao.mapper.DemoDataMapper;
import com.github.ruowen.demo.model.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DemoDataDao {
    @Autowired
    private DemoDataMapper demoDataMapper;

    public void addData(String bizId, String someData) {
        DemoData demoData = new DemoData();
        demoData.setBizId(bizId);
        demoData.setSomeData(someData);
        demoData.setCreateTime(new Date());
        demoData.setUpdateTime(new Date());
        int insert = demoDataMapper.insert(demoData);
        log.info("NewData:{}, addResult:{}", demoData, insert);
    }

    public DemoData getData(String bizId) {
        QueryWrapper<DemoData> query = new QueryWrapper<>();
        query.lambda()
                .eq(DemoData::getBizId, bizId);
        return demoDataMapper.selectOne(query);
    }
}
