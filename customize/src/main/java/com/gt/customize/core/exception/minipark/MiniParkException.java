package com.gt.customize.core.exception.minipark;

import com.gt.customize.common.enums.ResponseEnums;
import com.gt.customize.common.exception.SystemException;

/**
 * Created by psr on 2017/10/10 0010.
 */
public class MiniParkException extends SystemException {

    public MiniParkException(String message) {
        super(message);
    }

    public MiniParkException(int code, String message) {
        super(code, message);
    }

    public MiniParkException(ResponseEnums responseEnums) {
        super(responseEnums);
    }
}
