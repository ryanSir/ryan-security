package com.ryan.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author ryan
 * @version Id: RestExceptionHandler, v 0.1 2022/4/6 11:10 AM ryan Exp $
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestException.class)
    @ResponseBody
    public Map<String,Object> handlerException(RestException ex){
        System.out.println(ex);
        return null;
    }
}
