package com.github.enesusta.tasdik.max;

import com.github.enesusta.tasdik.validator.FieldValidator;

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
            if (validateableObject instanceof Number) {
                block:
                {
                    final Number number = (Number) validateableObject;
                    if (number.intValue() == 0)
                        break block;
                    final Max annotation = field.getAnnotation(Max.class);
                    valid = number.intValue() <= annotation.value();
                }
            } else if (validateableObject instanceof String) {
                block:
                {
                    final String string = (String) validateableObject;
                    if (string.isEmpty()) break block;
                    final Max annotation = field.getAnnotation(Max.class);
                    valid = string.length() <= annotation.value();
                }
            }

        } catch (NullPointerException e) {
            valid = false;
        }
        return valid;
    }
}
