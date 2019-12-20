package com.github.enesusta.validator.min;

import com.github.enesusta.validator.core.FieldValidator;

import java.lang.reflect.Field;

public class MinFieldValidator implements FieldValidator {

    private Object object;

    public MinFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public boolean isFieldValid(Field field) throws IllegalAccessException {

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
                    System.out.println("annotation = " + annotation.min());
                    valid = number.intValue() >= annotation.min();
                    System.out.println(field.getName() + " value + " + number.intValue() + "  first valid " + valid);
                }
            } else if (String.class.isInstance(validateableObject)) {
                block:
                {
                    String string = (String) validateableObject;
                    if (string.isEmpty()) break block;
                    final Min annotation = field.getAnnotation(Min.class);
                    valid = string.length() >= annotation.min();
                    System.out.println(field.getName() + " value + " + string.length() + "  first valid " + valid);
                }
            }

        } catch (NullPointerException e) {
            valid = false;
        }

        return valid;
    }
}
