package com.ryan.security.core.properties;

/**
 * @author ryan
 * @version Id: ImageCodeProperties, v 0.1 2022/4/13 5:24 PM ryan Exp $
 */
public class SmsCodeProperties {

    private int length = 6;
    private int expireIn = 60;

    private String url;

    /**
     * Getter method for property <tt>length</tt>.
     *
     * @return property value of length
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter method for property <tt>length</tt>.
     *
     * @param length value to be assigned to property length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Getter method for property <tt>expireIn</tt>.
     *
     * @return property value of expireIn
     */
    public int getExpireIn() {
        return expireIn;
    }

    /**
     * Setter method for property <tt>expireIn</tt>.
     *
     * @param expireIn value to be assigned to property expireIn
     */
    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    /**
     * Getter method for property <tt>url</tt>.
     *
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     *
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
