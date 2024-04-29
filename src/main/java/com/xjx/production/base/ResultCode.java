package com.xjx.production.base;

/**
 * 接口返回状态和错误提示
 *
 * @author xjx
 */
public enum ResultCode {
    /**
     * 返回状态码
     */
    SUCCESS(200, "成功"),
    FAIL(-1, "失败"),
    BAD_REQUEST(400, "错误请求"),
    UNAUTHORIZED(401,"未登录/登录过期"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "未找到"),
    EXCEPTION(500, "系统异常"),
    BUSINESSERROR(888, "业务异常");


    /**
     * code错误码
     */
    private Integer code;
    /**
     * 信息
     */
    private String message;

    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }
}
