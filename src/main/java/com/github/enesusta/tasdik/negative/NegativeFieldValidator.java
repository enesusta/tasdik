package com.github.enesusta.tasdik.negative;

import com.github.enesusta.tasdik.validator.FieldValidator;

import java.lang.reflect.Field;

public class NegativeFieldValidator implements FieldValidator {

    private Object object;

    public NegativeFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {

        field.setAccessible(true);
        boolean valid = true;

        try {

            final Number number = (Number) field.get(object);
            block:
            {
                if (number.intValue() == 0)
                    break block;
                valid = isNegative(number);
            }

        } catch (Exception e) {
            valid = false;
        }

        return valid;
    }

    private <E extends Number> boolean isNegative(final E e) {
        int value = e.intValue();
        return value < 0;
    }


}
