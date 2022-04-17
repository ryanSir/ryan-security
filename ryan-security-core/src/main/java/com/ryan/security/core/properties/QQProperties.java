package com.ryan.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author ryan
 * @version Id: QQProperties, v 0.1 2022/4/17 7:56 PM ryan Exp $
 */
public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    /**
     * Getter method for property <tt>providerId</tt>.
     *
     * @return property value of providerId
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * Setter method for property <tt>providerId</tt>.
     *
     * @param providerId value to be assigned to property providerId
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
