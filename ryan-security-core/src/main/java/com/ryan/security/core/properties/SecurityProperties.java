package com.ryan.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ryan
 * @version Id: SecurityProperties, v 0.1 2022/4/13 1:24 PM ryan Exp $
 */
@ConfigurationProperties(prefix = "ryan.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    private SocialProperties social =new SocialProperties();

    /**
     * Getter method for property <tt>social</tt>.
     *
     * @return property value of social
     */
    public SocialProperties getSocial() {
        return social;
    }

    /**
     * Setter method for property <tt>social</tt>.
     *
     * @param social value to be assigned to property social
     */
    public void setSocial(SocialProperties social) {
        this.social = social;
    }

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public ValidateCodeProperties getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
