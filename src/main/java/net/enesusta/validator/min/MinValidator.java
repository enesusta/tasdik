package net.enesusta.validator.min;

import net.enesusta.validator.core.FieldValidator;
import net.enesusta.validator.core.Validator;

import java.lang.reflect.Field;

public class MinValidator implements Validator {

    @Override
    public boolean isValid(Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final FieldValidator fieldValidator = new MinFieldValidator(object);
        boolean hasAnyFalse = false;

        for (Field field : fields)
            if (isAnnotationPresentWithMinAnnotation(field))
                if (!fieldValidator.isFieldValid(field))
                    hasAnyFalse = true;

        return !hasAnyFalse;
    }
}
