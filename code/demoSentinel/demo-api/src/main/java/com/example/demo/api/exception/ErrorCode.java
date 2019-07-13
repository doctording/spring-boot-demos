package com.example.demo.api.exception;

import java.util.Arrays;

public enum ErrorCode {
    // ok
    OK(0, "ok"),
    // 系统错误
    SYSTEM_ERROR(1, "System Error"),
    // 无权限
    PERMISSION_ERROR(2, "No permission"),
    ;

    private int code;

    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ErrorCode valueOf(int code) {
        return Arrays.stream(ErrorCode.values()).filter(item -> item.getCode() == code).findFirst().get();
    }
}
