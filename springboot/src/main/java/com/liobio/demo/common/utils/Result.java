package com.liobio.demo.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName Result.java
 * @createTime 2022/01/30/19:50:00
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result{
    private String code;
    private String msg;
    private Object data;

    public static Result success() {
        return new Result(Constants.CODE_200, "", null);
    }

    public static Result success(Object data) {
        return new Result(Constants.CODE_200, "", data);
    }

    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }

    public static Result error() {
        return new Result(Constants.CODE_500, "系统错误", null);
    }
}
