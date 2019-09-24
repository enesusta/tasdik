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
        Number number = null;

        final Optional<Field> fieldOptional = Optional.ofNullable(field);
        if (fieldOptional.isPresent()) {
            number = (Number) field.get(object);
            valid = isPositive(number);
        }

        return valid;
    }

    private <E extends Number> boolean isPositive(E e) {
        int value = (int) e.intValue();
        System.out.println("value = " + value);
        boolean bool = value >= 0;
        System.out.println(bool);
        return value >= 0;
    }


}
