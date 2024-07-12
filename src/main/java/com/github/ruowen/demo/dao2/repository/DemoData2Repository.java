package com.github.ruowen.demo.dao2.repository;

import com.github.ruowen.demo.model.DemoData2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DemoData2Repository extends JpaRepository<DemoData2, Integer> {
    DemoData2 findByBizId(String bizId);
    DemoData2 findByIdAndBizId(int id, String bizId);
    Page<DemoData2> findBySomeData(String someData, Pageable pageable);
}
