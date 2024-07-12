package com.github.ruowen.demo.dao2;

import com.github.ruowen.demo.dao2.repository.DemoData2Repository;
import com.github.ruowen.demo.model.DemoData2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class DemoData2Dao {
    @Autowired
    private DemoData2Repository demoData2Repository;
    @Autowired
    private EntityManager entityManager;

    public void addData(String bizId, String someData) {
        DemoData2 demoData = new DemoData2();
        demoData.setBizId(bizId);
        demoData.setSomeData(someData);
        DemoData2 save = demoData2Repository.save(demoData);
        log.info("NewData:{}, addResult:{}", demoData, save);
    }

    public DemoData2 getData(String bizId) {
        return demoData2Repository.findByBizId(bizId);
    }

    public DemoData2 getData(int id, String bizId) {
        return demoData2Repository.findByIdAndBizId(id, bizId);
    }

    public Page<DemoData2> getDataPage(String someData) {
        return demoData2Repository.findBySomeData(someData, Pageable.ofSize(20).withPage(0));
    }

    public DemoQueryDto getDto() {
        Query demoQueryDtoResult = entityManager.createNativeQuery("SELECT " +
                "demo_table.id as id1, " +
                "new_table.id as id2, " +
                "demo_table.biz_id as bizId, " +
                "demo_table.some_data as data1, " +
                "new_table.some_data as data2, " +
                "demo_table.create_time as createTime1, " +
                "new_table.create_time as createTime2 " +
                "FROM new_table, demo_table " +
                "where new_table.demo_id = demo_table.id;", DemoQueryDto.class);
        List resultList = demoQueryDtoResult.getResultList();
        for (Object result : resultList) {
            return (DemoQueryDto) result;
        }
        return null;
    }
}