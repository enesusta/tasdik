package com.github.enesusta.tasdik.min;

import com.github.enesusta.tasdik.validator.FieldValidator;

import java.lang.reflect.Field;

public class MinFieldValidator implements FieldValidator {

    private Object object;

    public MinFieldValidator(final Object object) {
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
                    final Min annotation = field.getAnnotation(Min.class);
                    valid = number.intValue() >= annotation.value();
                }
            } else if (String.class.isInstance(validateableObject)) {
                block:
                {
                    final String string = (String) validateableObject;
                    if (string.isEmpty()) break block;
                    final Min annotation = field.getAnnotation(Min.class);
                    valid = string.length() >= annotation.value();
                }
            }

        } catch (final NullPointerException e) {
            valid = false;
        }

        return valid;
    }

    @Override
    public String toString() {
        return "minFieldValitor";
    }
}
