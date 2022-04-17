package com.ryan.security.core.social.qq.config;

import com.ryan.security.core.properties.QQProperties;
import com.ryan.security.core.properties.SecurityProperties;
import com.ryan.security.core.social.qq.connect.QQConnectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * @author ryan
 * @version Id: QQAutoConfig, v 0.1 2022/4/17 7:59 PM ryan Exp $
 */
@Configuration
// 配置才生效
@ConditionalOnProperty(prefix = "ryan.security.social.qq",name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectFactory(qqConfig.getProviderId(),qqConfig.getAppId(),qqConfig.getAppSecret());
    }
}
