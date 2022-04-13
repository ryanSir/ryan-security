package com.ryan.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author ryan
 * @version Id: ValidateCodeException, v 0.1 2022/4/13 4:12 PM ryan Exp $
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
