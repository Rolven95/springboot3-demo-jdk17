package com.github.ruowen.demo.model;

import com.github.ruowen.demo.dao2.DemoQueryDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table(name = "demo_table")
@EntityListeners(AuditingEntityListener.class)
public class DemoData2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bizId;
    private String someData;
    @CreatedDate
    private Date createTime;
    @LastModifiedDate
    private Date updateTime;
}