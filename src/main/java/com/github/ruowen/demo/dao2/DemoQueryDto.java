package com.github.ruowen.demo.dao2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@MappedSuperclass
public class DemoQueryDto {
    @Id
    @Column(name = "id1")
    private Integer id1;
    @Column(name = "id2")
    private Integer id2;
    @Column(name = "bizId")
    private String bizId;
    @Column(name = "data1")
    private String data1;
    @Column(name = "data2")
    private String data2;
    @Column(name = "createTime1")
    private String createTime1;
    @Column(name = "createTime2")
    private String createTime2;
}
