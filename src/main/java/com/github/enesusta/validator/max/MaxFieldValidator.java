package com.github.enesusta.validator.max;

import com.github.enesusta.validator.core.FieldValidator;

import java.lang.reflect.Field;

public class MaxFieldValidator implements FieldValidator {

    private Object object;

    public MaxFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {

        field.setAccessible(true);
        boolean valid = true;
        Object validateableObject = null;

        try {
            validateableObject = field.get(object);
            if (Number.class.isInstance(validateableObject)) {
                block:
                {
                    final Number number = (Number) validateableObject;
                    if (number.intValue() == 0)
                        break block;
                    final Max annotation = field.getAnnotation(Max.class);
                    System.out.println("field is : + " + field.getName());
                    System.out.println("int value :  " + number.intValue());
                    System.out.println("annotation.max : " + annotation.max());
                    valid = number.intValue() <= annotation.max();
                }
            } else if (String.class.isInstance(validateableObject)) {
                block:
                {
                    final String string = (String) validateableObject;
                    if (string.isEmpty()) break block;
                    final Max annotation = field.getAnnotation(Max.class);
                    valid = string.length() <= annotation.max();
                }
            }

        } catch (NullPointerException e) {
            valid = false;
        }
        return valid;
    }
}