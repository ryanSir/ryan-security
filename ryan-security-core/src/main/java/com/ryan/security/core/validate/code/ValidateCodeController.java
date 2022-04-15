package com.ryan.security.core.validate.code;

import com.ryan.security.core.properties.SecurityProperties;
import com.ryan.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author ryan
 * @version Id: ValidateCodeController, v 0.1 2022/4/13 3:37 PM ryan Exp $
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    public static final String SESSION_KEY_SMS = "SESSION_KEY_SMS";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;

    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;

    @Autowired
     private SmsCodeSender smsCodeSender;

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 根据随机数生成图片
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generateCode(new ServletWebRequest(request));

        // 将随机数存到session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);

        // 将生成的图片写到接口响应中
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());

    }

    @GetMapping("/code/sms")
    public void sms(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {

        // 根据随机数生成图片
        ValidateCode smsCode = smsCodeGenerator.generateCode(new ServletWebRequest(request));

        // 将随机数存到session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_SMS, smsCode);

        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
        smsCodeSender.send(mobile, smsCode.getCode());

    }

}
