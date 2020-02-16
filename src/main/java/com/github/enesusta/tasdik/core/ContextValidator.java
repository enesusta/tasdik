package com.github.enesusta.tasdik.core;

import java.lang.reflect.Field;

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

        return hasAny(booleans);
    }
}
