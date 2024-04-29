package com.xjx.production.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author xjx
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @ApiModelProperty(value = "状态码",example = "200")
    private int code;

    @Getter
    @Setter
    @ApiModelProperty(value = "状态描述")
    private String message;

    @Getter
    @Setter
    @ApiModelProperty(value = "返回数据")
    private T data;

    public static <T> R<T> ok() {
        return restResult(null, ResultCode.SUCCESS.getCode(), null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, ResultCode.SUCCESS.getCode(), null);
    }

    public static <T> R<T> ok(T data, String message) {
        return restResult(data, ResultCode.SUCCESS.getCode(), message);
    }

    public static <T> R<T> fail() {
        return restResult(null, ResultCode.FAIL.getCode(), null);
    }

    public static <T> R<T> fail(String message) {
        return restResult(null, ResultCode.FAIL.getCode(), message);
    }

    /*public static <T> R<T> fail(T data) {
        return restResult(data, ResultCode.FAIL.getCode(), null);
    }*/

    public static <T> R<T> fail(String message,int code) {
        return restResult(null, code, message);
    }

    public static <T> R<T> fail(ResultCode resultCode) {
        return restResult(null, resultCode.getCode(), resultCode.getMessage());
    }

    /*public static <T> R<T> fail(T data, String message) {
        return restResult(data, ResultCode.FAIL.getCode(), message);
    }*/

    private static <T> R<T> restResult(T data, int code, String message) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMessage(message);
        return apiResult;
    }

}

