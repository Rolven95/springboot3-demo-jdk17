package com.github.ruowen.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<D> {
    private D data;
    private Integer code;
    private String msg;

    public static <D> Result<D> succ(D data) {
        return new Result<>(data, ResultCode.OK.getCode(), ResultCode.OK.getMsg());
    }

    public static <D> Result<D> fail(Integer code, String msg) {
        return new Result<>(null, code, msg);
    }
}