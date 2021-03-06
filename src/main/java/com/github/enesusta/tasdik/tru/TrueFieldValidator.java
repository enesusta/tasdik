package com.github.enesusta.tasdik.tru;

import com.github.enesusta.tasdik.validator.FieldValidator;

import java.lang.reflect.Field;

public final class TrueFieldValidator implements FieldValidator {

    private final Object object;

    public TrueFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {
        field.setAccessible(true);
        return (boolean) field.get(object);
    }
}
