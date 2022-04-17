package com.ryan.security.core.properties;

/**
 * @author ryan
 * @version Id: SocialProperties, v 0.1 2022/4/17 7:57 PM ryan Exp $
 */
public class SocialProperties {

    private QQProperties qq = new QQProperties();

    /**
     * Getter method for property <tt>qq</tt>.
     *
     * @return property value of qq
     */
    public QQProperties getQq() {
        return qq;
    }

    /**
     * Setter method for property <tt>qq</tt>.
     *
     * @param qq value to be assigned to property qq
     */
    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
