package net.enesusta.validator.positive;

import net.enesusta.validator.core.FieldValidator;
import net.enesusta.validator.nonnull.NonNull;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.stream.IntStream;

public class PositiveFieldValidator implements FieldValidator {

    private Object object;

    public PositiveFieldValidator(final Object object) {
        this.object = object;
    }

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

    private <E extends Number> boolean isPositive(E e, final Field field) {
        int value = e.intValue();
        result(field.getName(), value, value >= 0);
        return value >= 0;
    }

    private void result(String name, int a, boolean b) {
        System.out.println("\n ===================== ");
        System.out.println(name + " = " + a + " isValid = " + b);
        System.out.println(" ===================== ");
    }


}
