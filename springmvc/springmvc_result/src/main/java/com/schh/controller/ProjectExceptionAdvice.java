package com.schh.controller;

import com.schh.exception.BusinessException;
import com.schh.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        //log
        //send msg to admin
        //send email to developer
        return new Result(ex.getCode(), null, ex.getMessage());

    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex) {
        return new Result(ex.getCode(), null, ex.getMessage());

    }


    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        //log
        //send msg to admin
        //send email to developer
        return new Result(Code.SYSTEM_UNKNOWN_ERR, null, "system busy, please retry later");
    }
}
