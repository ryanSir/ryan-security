package com.ryan.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author ryan
 * @version Id: ValidateCodeGenerator, v 0.1 2022/4/13 5:59 PM ryan Exp $
 */
public interface ValidateCodeGenerator {

     ValidateCode generateCode( ServletWebRequest request);
}
