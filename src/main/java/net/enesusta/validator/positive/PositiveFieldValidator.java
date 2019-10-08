package net.enesusta.validator.positive;

import net.enesusta.validator.core.FieldValidator;
import java.lang.reflect.Field;

/**
 * @author Enes Usta
 * @see net.enesusta.validator.core.FieldValidator
 * @since 0.0.1
 */

public class PositiveFieldValidator implements FieldValidator {


    private Object object;

    /**
     *
      * @param object a
     */

    @SuppressWarnings("checkstyle:HiddenField")
    public PositiveFieldValidator(final Object object) {
        this.object = object;
    }

    /**
     *
     * @param field
     * @return
     * @throws IllegalAccessException
     */

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {

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
     * @param e e
     * @param field a
     * @param <E> a
     * @return boolean
     */

    private <E extends Number> boolean isPositive(final E e, final Field field) {
        int value = e.intValue();
        result(field.getName(), value, value >= 0);
        return value >= 0;
    }

    /**
     *
     * @param name
     * @param a
     * @param b
     *
     */
    private void result(final String name, final int a, final boolean b) {
        System.out.println("\n ===================== ");
        System.out.println(name + " = " + a + " isValid = " + b);
        System.out.println(" ===================== ");
    }


}
