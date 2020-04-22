package com.iooiee.common.handler;

import com.iooiee.common.constants.ResultCodeEnum;
import com.iooiee.common.exception.CustomException;
import com.iooiee.common.utils.ExceptionUtil;
import com.iooiee.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:通用异常处理
 * @Author: Yanggc
 * Time: 16:46
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**-------- 通用异常处理方法 --------**/
    @ResponseBody
    @ExceptionHandler
    public R error(Exception e) {
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }

    /**-------- 指定异常处理方法 --------**/
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public R error(NullPointerException e) {
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.NULL_POINTER);
    }

    /**-------- 自定义定异常处理方法 --------**/
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public R error(CustomException e) {
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }

}