package com.github.enesusta.validator.core;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class ContextValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();

        final FieldContext fieldContext = FieldContext.getInstance(object);

        boolean[] booleans = new boolean[fields.length];

        byte counter = (byte) 0;
        for (Field field : fields)
            booleans[counter++] = fieldContext.isValid(field);

        System.out.println(Arrays.toString(booleans));
        return hasAny(booleans);
    }
}
