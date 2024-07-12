package com.github.ruowen.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    OK(200, "ok"),
    FAILED(500, "FAILED");

    private Integer code;
    private String msg;
}
