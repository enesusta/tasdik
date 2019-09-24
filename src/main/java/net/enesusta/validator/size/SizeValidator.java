package net.enesusta.validator.size;

import net.enesusta.validator.core.FieldValidator;
import net.enesusta.validator.core.Validator;

import java.lang.reflect.Field;

public class SizeValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        final FieldValidator fieldValidator = new SizeFieldValidator(object);


        return false;
    }
}
