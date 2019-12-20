package com.github.enesusta.validator.negative;

import com.github.enesusta.validator.core.Validator;
import com.github.enesusta.validator.core.FieldValidator;

import java.lang.reflect.Field;

public class NegativeValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final FieldValidator fieldValidator = new NegativeFieldValidator(object);
        boolean hasAnyFalse = false;

        for (Field field : fields)
            if (isAnnotationPresentWithNegativeAnnotation(field))
                if (!fieldValidator.isFieldValid(field))
                    hasAnyFalse = true;


        return !hasAnyFalse;
    }
}
