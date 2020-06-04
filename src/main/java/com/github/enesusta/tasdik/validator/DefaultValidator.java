package com.github.enesusta.tasdik.validator;

import com.github.enesusta.tasdik.core.FieldContext;

import java.lang.reflect.Field;

public final class DefaultValidator implements Validator {

    private static DefaultValidator instance = null;

    private DefaultValidator() {

    }

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

    public static DefaultValidator getInstance() {
        if (instance == null)
            instance = new DefaultValidator();
        return instance;
    }
}
