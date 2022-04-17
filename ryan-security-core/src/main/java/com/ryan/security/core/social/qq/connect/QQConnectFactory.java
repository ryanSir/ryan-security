package com.ryan.security.core.social.qq.connect;

import com.ryan.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author ryan
 * @version Id: QQConnectFactory, v 0.1 2022/4/17 7:34 PM ryan Exp $
 */
public class QQConnectFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectFactory(String providerId, String appId,String appSecret) {
        super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapter());
    }
}
