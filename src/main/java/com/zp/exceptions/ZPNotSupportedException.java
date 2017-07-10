package com.zp.exceptions;

import com.zp.util.I18n;

/**
 * Created by topera on 09/07/17.
 */
public class ZPNotSupportedException extends ZPException {

    public ZPNotSupportedException() {
        super(I18n.getMessage("error.not.implemented"));
    }
}
