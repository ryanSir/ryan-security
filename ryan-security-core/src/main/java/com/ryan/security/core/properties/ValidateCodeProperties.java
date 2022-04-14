package com.ryan.security.core.properties;

/**
 * @author ryan
 * @version Id: ValidateCodeProperties, v 0.1 2022/4/13 5:26 PM ryan Exp $
 */
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

    /**
     * Getter method for property <tt>image</tt>.
     *
     * @return property value of image
     */
    public ImageCodeProperties getImage() {
        return image;
    }

    /**
     * Setter method for property <tt>image</tt>.
     *
     * @param image value to be assigned to property image
     */
    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    /**
     * Getter method for property <tt>sms</tt>.
     *
     * @return property value of sms
     */
    public SmsCodeProperties getSms() {
        return sms;
    }

    /**
     * Setter method for property <tt>sms</tt>.
     *
     * @param sms value to be assigned to property sms
     */
    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }
}
