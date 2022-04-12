package com.ryan.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ryan
 * @version Id: DeferredResultHolder, v 0.1 2022/4/11 2:44 PM ryan Exp $
 */
@Component
public class DeferredResultHolder {
    Map<String, DeferredResult<String>> map = new HashMap<>();

    /**
     * Getter method for property <tt>map</tt>.
     *
     * @return property value of map
     */
    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    /**
     * Setter method for property <tt>map</tt>.
     *
     * @param map value to be assigned to property map
     */
    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
