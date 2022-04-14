package com.ryan.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author ryan
 * @version Id: ImageCode, v 0.1 2022/4/13 3:33 PM ryan Exp $
 */
public class ImageCode extends ValidateCode {

    /** 图片信息，展示 */
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code,int expireIn) {
        super(code,expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super(code,expireTime);
        this.image = image;
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

}
