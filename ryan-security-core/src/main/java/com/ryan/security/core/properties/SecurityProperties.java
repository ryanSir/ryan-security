package com.ryan.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ryan
 * @version Id: SecurityProperties, v 0.1 2022/4/13 1:24 PM ryan Exp $
 */
@ConfigurationProperties(prefix = "ryan.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();


    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
