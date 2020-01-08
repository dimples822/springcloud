package com.dimples.common.exception;

import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.transport.ResponseDTO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;

import lombok.extern.slf4j.Slf4j;

/**
 * 基础异常捕捉
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/27
 */
@Slf4j
public class BaseExceptionHandler {

    /**
     * Exception
     *
     * @param e Exception
     * @return ResponseDTO
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDTO handleException(Exception e) {
        log.error("系统内部异常,异常信息: ", e);
        return ResponseDTO.failed(CodeAndMessageEnum.SERVER_ERROR);
    }

    /**
     * BizException
     *
     * @param e BizException
     * @return ResponseDTO
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDTO handleBizException(BizException e) {
        log.error("业务错误", e);
        return ResponseDTO.failed(e.getMessage());
    }

    /**
     * AccessDeniedException
     *
     * @return ResponseDTO
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseDTO handleAccessDeniedException() {
        return ResponseDTO.failed(CodeAndMessageEnum.NOT_AUTH);
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return ResponseDTO
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ResponseDTO.failed(message.toString());
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return ResponseDTO
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO handleBindException(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ResponseDTO.failed(message.toString());
    }

}















