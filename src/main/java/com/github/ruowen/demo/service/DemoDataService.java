package com.github.ruowen.demo.service;

import com.github.ruowen.demo.dao.DemoDataDao;
import com.github.ruowen.demo.model.DemoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DemoDataService {
    @Autowired
    private DemoDataDao demoDataDao;

    /**
     * Add ramdom data
     *
     * @return data added
     */
    public DemoData createRandomData() {
        String bizId = "biz-id-" + UUID.randomUUID();
        String someData = UUID.randomUUID().toString();
        demoDataDao.addData(bizId, someData);
        return demoDataDao.getData(bizId);
    }
}
