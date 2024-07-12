package com.github.ruowen.demo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("demo_table")
public class DemoData {
    @TableId
    private Integer id;
    private String bizId;
    private String someData;
    private Date createTime;
    private Date updateTime;
}