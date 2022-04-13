package com.ryan.code;

import com.ryan.security.core.validate.code.ImageCode;
import com.ryan.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author ryan
 * @version Id: DemoImageCodeGenerator, v 0.1 2022/4/13 6:16 PM ryan Exp $
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generateCode(ServletWebRequest request) {
        System.out.println("更高级的图片验证码生成逻辑");
        return null;
    }
}
