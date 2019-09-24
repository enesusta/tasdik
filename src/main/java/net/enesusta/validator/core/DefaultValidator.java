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

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        boolean valid[] = prepareValidationArray();

        final FieldValidator nullValidator = new NonNullFieldValidator(object);
        final FieldValidator positiveValidator = new PositiveFieldValidator(object);

        for (Field field : fields) {
            field.setAccessible(true);
            if (isAnnotationPresentWithNonNullAnnotation(field))
                valid[0] = nullValidator.isFieldValid(field);
            else if (isAnnotationPresentWithPositiveAnnotation(field))
                valid[1] = positiveValidator.isFieldValid(field);

        }

        return valid[0];
    }

    private boolean[] prepareValidationArray() {
        boolean[] booleans = new boolean[5];
        IntStream.range(0, 5).forEach(i -> {
            booleans[i] = true;
        });
        return booleans;
    }

}
