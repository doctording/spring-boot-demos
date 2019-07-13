package com.example.demo.api.exception;

/**
 * @Author mubi
 * @Date 2019/7/13 8:16 PM
 */
public class ProException extends Exception{
    //错误代码
    private int errorCode;

    public ProException(){
        super(ErrorCode.SYSTEM_ERROR.getMessage());
        errorCode = ErrorCode.SYSTEM_ERROR.getCode();
    }

    public ProException(String message) {
        super(message);
        this.errorCode = ErrorCode.SYSTEM_ERROR.getCode();
    }

    public ProException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ProException(ErrorCode e) {
        super(e.getMessage());
        this.errorCode = e.getCode();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
