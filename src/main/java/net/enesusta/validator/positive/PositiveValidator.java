package net.enesusta.validator.positive;

import net.enesusta.validator.core.FieldValidator;
import net.enesusta.validator.core.Validator;
import net.enesusta.validator.positive.PositiveFieldValidator;

import java.lang.reflect.Field;

public class PositiveValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final FieldValidator fieldValidator = new PositiveFieldValidator(object);
        boolean hasAnyFalse = false;

        for (Field field : fields)
            if (isAnnotationPresentWithPositiveAnnotation(field))
                if (!fieldValidator.isFieldValid(field))
                    hasAnyFalse = true;

        return !hasAnyFalse;
    }
}
