
package com.github.enesusta.validator.positive;

import com.github.enesusta.validator.core.FieldValidator;

import java.lang.reflect.Field;

/**
 * @author Enes Usta
 * @see FieldValidator
 * @since 0.0.1
 */

public class PositiveFieldValidator implements FieldValidator {

    private Object object;

    /**
     * @param object a
     */

    @SuppressWarnings("checkstyle:HiddenField")
    public PositiveFieldValidator(final Object object) {
        this.object = object;
    }

    /**
     * @param field
     * @return boolean
     * @throws IllegalAccessException
     */

    @Override
    public final boolean isFieldValid(final Field field)
        throws IllegalAccessException {

        field.setAccessible(true);
        boolean valid = true;

        try {

            final Number number = (Number) field.get(object);
            valid = isPositive(number, field);

        } catch (NullPointerException e) {
            valid = false;
        }

        return valid;
    }

    /**
     * @param e     e
     * @param field a
     * @param <E>   a
     * @return boolean
     */

    private <E extends Number> boolean isPositive(final E e,
                                                  final Field field) {
        int value = e.intValue();
        //result(field.getName(), value, value >= 0);
        return value >= 0;
    }



}
