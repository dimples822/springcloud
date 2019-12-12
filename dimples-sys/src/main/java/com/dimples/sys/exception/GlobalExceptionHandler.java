package com.dimples.sys.exception;

import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.exception.BizException;
import com.dimples.common.result.R;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常捕获<br>
 *
 * @author zhongyj
 * @date 2019/7/1
 */
@Slf4j
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截业务异常
     *
     * @param e BizException
     * @return R
     */
    @ExceptionHandler(BizException.class)
    public R bizException(BizException e) {
        log.error("业务异常:" + e.getMessage());
        return R.error(e.getCode(), e.getMessage());
    }

    /**
     * 拦截系统异常
     *
     * @param e Exception
     * @return R
     */
    @ExceptionHandler(RuntimeException.class)
    public R exceptionHandler(RuntimeException e) {
        log.error("系统异常:" + e.getMessage());
        return R.error(CodeAndMessageEnum.SERVER_ERROR.getCode(), CodeAndMessageEnum.SERVER_ERROR.getMessage());
    }

}













