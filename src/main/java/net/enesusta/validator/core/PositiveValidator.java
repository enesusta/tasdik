package net.enesusta.validator.core;

import net.enesusta.validator.positive.PositiveFieldValidator;

import java.lang.reflect.Field;

public class PositiveValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final FieldValidator fieldValidator = new PositiveFieldValidator(object);
        boolean isValid = true;
        boolean hasAnyFalse = false;

        for (Field field : fields)
            if (isAnnotationPresentWithPositive(field))
                if (!fieldValidator.isFieldValid(field))
                    hasAnyFalse = true;

        return !hasAnyFalse;
    }
}
