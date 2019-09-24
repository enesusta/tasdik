package net.enesusta.validator.core;

import net.enesusta.validator.core.log.LogUtils;
import net.enesusta.validator.nonnull.NonNull;
import net.enesusta.validator.nonnull.NonNullFieldValidator;
import net.enesusta.validator.positive.Positive;
import net.enesusta.validator.positive.PositiveFieldValidator;

import java.lang.reflect.Field;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DefaultValidator implements Validator {

    private final Object object;

    public DefaultValidator(final Object object) {
        this.object = object;
    }


    @Override
    public final boolean isValid() throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        boolean valid[] = prepareValidationArray();

        final FieldValidator positiveValidator = new PositiveFieldValidator(object);

        for (Field field : fields) {
            field.setAccessible(true);

        }

        return valid[0];
    }

    private boolean[] prepareValidationArray() {
        boolean[] booleans = new boolean[5];
        IntStream.range(0, 5).forEach(i -> {
            booleans[i] = false;
        });
        return booleans;
    }

    private boolean isAnnotationPresentWithNonNull(final Field field) throws IllegalAccessException {

        boolean isNull = true;
        final FieldValidator nullValidator = new NonNullFieldValidator(object);

        if (field.isAnnotationPresent(NonNull.class))
            isNull = nullValidator.isFieldValid(field);
        else
            isNull = false;

        return field.isAnnotationPresent(NonNull.class);
    }

    private boolean isAnnotationPresentWithPositive(final Field field) {
        return field.isAnnotationPresent(Positive.class);
    }

}
