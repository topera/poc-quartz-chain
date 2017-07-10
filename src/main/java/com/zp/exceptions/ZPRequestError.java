package com.zp.exceptions;

import com.zp.util.I18n;

/**
 * Created by topera on 09/07/17.
 */
public class ZPRequestError extends ZPException {

    public ZPRequestError(Integer status) {
        super(I18n.getMessage("error.request.error", status.toString()));
    }
}
