package com.github.ruowen.demo.dao2;

import com.github.ruowen.demo.SpringbootApplication;
import com.github.ruowen.demo.model.DemoData2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringbootApplication.class)
@ActiveProfiles("local")
class DemoData2DaoTest {
    @Autowired
    private DemoData2Dao demoData2Dao;

    @Test
    void addData() {
        for (int i = 0; i < 10; i++) {
            demoData2Dao.addData(UUID.randomUUID().toString(), "some");
        }
    }

    @Test
    void getData() {
        List<String> bizId = new ArrayList<>();
        bizId.add("13eb5e03-702f-435b-9e7c-797a110bd835"); // 1949220867
        bizId.add("43c39453-3230-42ea-92c9-084b6aa4dffb"); //
        DemoData2 data1 = demoData2Dao.getData(bizId.get(0));
        DemoData2 data2 = demoData2Dao.getData(bizId.get(1));
        log.info("R1:{}", data1);
        log.info("R2:{}", data2);

        DemoData2 data = demoData2Dao.getData(1949220867, bizId.get(0));
        log.info("M:{}", data);

        Page<DemoData2> some = demoData2Dao.getDataPage("some");
        log.info("P:{}", some);
    }

    @Test
    void getDto() {
        DemoQueryDto dto = demoData2Dao.getDto();
        log.info("R:{}", dto);
    }
}