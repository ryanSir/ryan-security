package com.ryan.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ryan
 * @version Id: MyConstraintValidator, v 0.1 2022/4/2 5:12 PM ryan Exp $
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Override
    public void initialize(MyConstraint myConstraint) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("自定义校验参数：" + value);
        return false;
    }
}
