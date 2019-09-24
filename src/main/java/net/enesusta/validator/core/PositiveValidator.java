package net.enesusta.validator.core;

import java.lang.reflect.Field;

public class PositiveValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields) {

        }

        return false;
    }
}
