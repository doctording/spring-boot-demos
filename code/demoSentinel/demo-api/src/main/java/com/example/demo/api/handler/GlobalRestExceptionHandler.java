package com.example.demo.api.handler;


import com.example.demo.api.exception.ErrorCode;
import com.example.demo.api.exception.ProException;
import com.example.demo.api.response.ProResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author mubi
 * @Date 2019/2/20 3:26 PM
 * rest api 异常并统一处理
 */
@ControllerAdvice
@Slf4j
public class GlobalRestExceptionHandler {

    /**
     * 全局异常捕捉处理
     * @param
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ProResponse handleException(Exception e){
        log(e);
        return new ProResponse(ErrorCode.SYSTEM_ERROR.getCode(),
                e.getMessage());
    }

    /**
     * 拦截捕捉自定义异常 DruidManagerException.class
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ProException.class)
    public ProResponse handleDruidException(ProException e){
        log(e);
        return new ProResponse(e);
    }

    private void log(Exception e) {
        log.error("detail:", e);
    }
}
