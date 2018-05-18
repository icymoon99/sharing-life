package com.rias.sharing.life.merchant.exception;

import com.rias.sharing.life.common.exception.GlobalException;
import com.rias.sharing.life.common.result.CodeMsg;
import com.rias.sharing.life.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @name: GlobalExceptionHandler
 * @author: lucifinier
 * @date: 2018/4/24 16:50
 * @description: 全局异常拦截器
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {

        log.error("Exception: ", e);

        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;

            return Result.error(ex.getCm());
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;

            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();

            return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
