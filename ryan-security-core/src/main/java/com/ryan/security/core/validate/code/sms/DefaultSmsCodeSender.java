package com.ryan.security.core.validate.code.sms;

/**
 * @author ryan
 * @version Id: DefaultSmsCodeSender, v 0.1 2022/4/14 5:27 PM ryan Exp $
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机：" + mobile + " 发送短信验证码" + code);
    }
}
