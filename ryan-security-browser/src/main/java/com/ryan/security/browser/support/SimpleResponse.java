package com.ryan.security.browser.support;

/**
 * @author ryan
 * @version Id: SimpleResponse, v 0.1 2022/4/13 1:16 PM ryan Exp $
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    /**
     * Getter method for property <tt>content</tt>.
     *
     * @return property value of content
     */
    public Object getContent() {
        return content;
    }

    /**
     * Setter method for property <tt>content</tt>.
     *
     * @param content value to be assigned to property content
     */
    public void setContent(Object content) {
        this.content = content;
    }
}
