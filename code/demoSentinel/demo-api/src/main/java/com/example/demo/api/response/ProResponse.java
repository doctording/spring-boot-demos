package com.example.demo.api.response;

import com.example.demo.api.exception.ErrorCode;
import com.example.demo.api.exception.ProException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author mubi
 * @Date 2019/7/13 8:40 PM
 */
@Data
@NoArgsConstructor
public class ProResponse<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    public ProResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ProResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public ProResponse(T data) {
        this.code = ErrorCode.OK.getCode();
        this.message = ErrorCode.OK.name();
        this.data = data;
    }

    public ProResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = null;
    }

    public ProResponse(ProException e) {
        this.code = e.getErrorCode();
        this.message = e.getMessage();
        this.data = null;
    }

}
