package com.ryan.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author ryan
 * @version Id: ImageCode, v 0.1 2022/4/13 3:33 PM ryan Exp $
 */
public class ImageCode {

    /** 图片信息，展示 */
    private BufferedImage image;

    /** 随机数 */
    private String code;

    /** 过期时间 */
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code,int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }

    /**
     * Getter method for property <tt>image</tt>.
     *
     * @return property value of image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Setter method for property <tt>image</tt>.
     *
     * @param image value to be assigned to property image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for property <tt>code</tt>.
     *
     * @param code value to be assigned to property code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>expireTime</tt>.
     *
     * @return property value of expireTime
     */
    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    /**
     * Setter method for property <tt>expireTime</tt>.
     *
     * @param expireTime value to be assigned to property expireTime
     */
    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }
}
