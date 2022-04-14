package com.ryan.security.core.validate.code.sms;

/**
 * @author ryan
 * @version Id: SmsCodeSender, v 0.1 2022/4/14 5:25 PM ryan Exp $
 */
public interface SmsCodeSender {

    void send(String mobile,String code);
}
