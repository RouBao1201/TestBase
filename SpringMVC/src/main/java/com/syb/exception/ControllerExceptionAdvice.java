package com.syb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Abin
 * @Description:
 * @Date: Created in 19:30 2021/4/29
 * @Modified By:
 */
@ControllerAdvice("com.syb.controller")
@Slf4j
public class ControllerExceptionAdvice {

    @ExceptionHandler
    @ResponseBody
    public String ValidControllerException(BindException bindException){
        log.debug("paramError-BindException = {}",bindException.getFieldError().getDefaultMessage());
        return bindException.getFieldError().getDefaultMessage();
    }

    @ExceptionHandler
    @ResponseBody
    public String ControllerException(Exception e){
        log.debug("paramError-BindException = {}",e.getMessage());
        return e.getMessage();
    }
}
