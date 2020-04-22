package com.iooiee.common.exception;

import com.iooiee.common.constants.ResultCodeEnum;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @Author: Yanggc
 * Time: 16:46
 */

@Data
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "CMSException{" + "code=" + code + ", message=" + this.getMessage() + '}';
    }
}
