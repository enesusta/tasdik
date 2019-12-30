package com.github.enesusta.validator.True;

import com.github.enesusta.validator.core.FieldValidator;
import com.github.enesusta.validator.core.Validator;

import java.lang.reflect.Field;

public final class TrueValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final FieldValidator fieldValidator = new TrueFieldValidator(object);
        boolean hasAnyFalse = false;

        for (final Field field : fields) {
            if (isAnnotationPresentWithTrueAnnotation(field))
                if (!fieldValidator.isFieldValid(field))
                    hasAnyFalse = true;
        }

        return !hasAnyFalse;
    }
}
