package com.ryan.security.core.properties;

/**
 * @author ryan
 * @version Id: ImageCodeProperties, v 0.1 2022/4/13 5:24 PM ryan Exp $
 */
public class ImageCodeProperties {

    private int width = 67;
    private int height = 23;
    private int length = 4;
    private int expireIn = 60;

    private String url;

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

    /**
     * Getter method for property <tt>width</tt>.
     *
     * @return property value of width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setter method for property <tt>width</tt>.
     *
     * @param width value to be assigned to property width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Getter method for property <tt>height</tt>.
     *
     * @return property value of height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter method for property <tt>height</tt>.
     *
     * @param height value to be assigned to property height
     */
    public void setHeight(int height) {
        this.height = height;
    }

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
}
