package com.example01.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 统一返回结果
 * @param <T>  泛型-可以接受任何参数
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> {
    //状态码
    private Integer code;
    //提示信息
    private String message;
    //数据
    private T data;

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Getter
    private enum Code {
        ok(200),
        fail(500);

        private final Integer code;

        Code(Integer code) {
            this.code = code;
        }
    }

    public static <T> R<T> ok() {
        return new R<T>(Code.ok.getCode(), "成功", null);
    }

    public static <T> R<T> ok(String message) {
        return new R<T>(Code.ok.getCode(), message, null);
    }

    public static <T> R<T> ok(T data) {
        return new R<T>(Code.ok.getCode(), "成功", data);
    }

    public static <T> R<T> ok(String message, T data) {
        return new R<T>(Code.ok.getCode(), message, data);
    }

    public static <T> R<T> fail() {
        return new R<T>(Code.fail.getCode(), "失败", null);
    }

    public static <T> R<T> fail(String message) {
        return new R<T>(Code.fail.getCode(), message, null);
    }

    public static <T> R<T> other(Integer code, String message, T data) {
        return new R<T>(code, message, data);
    }

    @Override
    public String toString() {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
