package com.zp.exceptions;

import com.zp.util.I18n;

/**
 * Used when request has error
 * Created by rafael on 18/06/17.
 */
public class ZPRequestError extends ZPException {

    public ZPRequestError(Integer status) {
        super(I18n.getMessage("error.request.error", status.toString()));
    }
}
