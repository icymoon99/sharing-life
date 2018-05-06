package com.rias.sharing.life.hotel.core.exception;


import com.rias.sharing.life.hotel.core.result.CodeMsg;

/**
 * @name: GlobalException
 * @author: lucifinier
 * @date: 2018/4/24 16:32
 * @description: 全局异常类
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1633696976552960104L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
