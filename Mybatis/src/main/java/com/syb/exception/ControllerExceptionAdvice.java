package com.syb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Abin
 * @Description:
 * @date: Created in 19:30 2021/4/29
 * @Modified By:
 */
@Slf4j
@ControllerAdvice("com.syb.controller")
public class ControllerExceptionAdvice {

    @ExceptionHandler
    @ResponseBody
    public String validControllerException(BindException bindException) {
        log.debug("paramError.BindException = {}", bindException.getFieldError().getDefaultMessage());
        return bindException.getFieldError().getDefaultMessage();
    }


    /**
     * @author Abin
     * @date Create in 2021/4/30 22:56
     * @Param [e]
     * @Description
     */
    @ExceptionHandler
    @ResponseBody
    public String controllerException(Exception e) {
        log.debug("异常信息 = {}", e.getMessage());
        return e.getMessage();
    }



    /**
     * @author Abin
     * @date Create in 2021/4/30 22:56
     * @Param [e]
     * @Description
     */
    @ExceptionHandler
    @ResponseBody
    public String controllerException(NullPointerException e) {
        log.debug("空指针异常");
        return e.getMessage();
    }
}
