package com.ryan.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author ryan
 * @version Id: MockQueue, v 0.1 2022/4/11 2:40 PM ryan Exp $
 */
@Component
public class MockQueue {

    private String placeOrder;

    private String completeOrder;

    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * Getter method for property <tt>placeOrder</tt>.
     *
     * @return property value of placeOrder
     */
    public String getPlaceOrder() {
        return placeOrder;
    }

    /**
     * Setter method for property <tt>placeOrder</tt>.
     *
     * @param placeOrder value to be assigned to property placeOrder
     */
    public void setPlaceOrder(String placeOrder) throws InterruptedException {
        new Thread(() ->{
            logger.info("接到下单请求, " + placeOrder);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            logger.info("下单请求处理完毕, " + placeOrder);
        }).start();

    }

    /**
     * Getter method for property <tt>completeOrder</tt>.
     *
     * @return property value of completeOrder
     */
    public String getCompleteOrder() {
        return completeOrder;
    }

    /**
     * Setter method for property <tt>completeOrder</tt>.
     *
     * @param completeOrder value to be assigned to property completeOrder
     */
    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
