package com.ryan.security.core.validate.code;

import com.ryan.security.core.properties.SecurityProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author ryan
 * @version Id: ImageCodeGenerator, v 0.1 2022/4/13 6:01 PM ryan Exp $
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator{

    @Autowired
    private SecurityProperties securityProperties;

    @Override
     public ValidateCode generateCode( ServletWebRequest request) {
            String code = RandomStringUtils.randomAlphanumeric(securityProperties.getCode().getSms().getLength());
            return new ValidateCode(code,securityProperties.getCode().getSms().getExpireIn());
    }

    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * Getter method for property <tt>securityProperties</tt>.
     *
     * @return property value of securityProperties
     */
    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    /**
     * Setter method for property <tt>securityProperties</tt>.
     *
     * @param securityProperties value to be assigned to property securityProperties
     */
    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
