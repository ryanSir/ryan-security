package com.ryan.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ryan
 * @version Id: TimeAspect, v 0.1 2022/4/7 5:36 PM ryan Exp $
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.ryan.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("time aspect start");
        long start = new Date().getTime();

        Object o = pjp.proceed();
        System.out.println("time aspect 耗时：" + (new Date().getTime() - start));

        System.out.println("time aspect end");
        return o;
    }

}
