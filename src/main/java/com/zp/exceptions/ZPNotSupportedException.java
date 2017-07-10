package com.zp.exceptions;

import com.zp.util.I18n;

/**
 * Used when a operation is not implemented yet.
 * Created by rafael on 18/06/17.
 */
public class ZPNotSupportedException extends ZPException {

    public ZPNotSupportedException() {
        super(I18n.getMessage("error.not.implemented"));
    }
}
