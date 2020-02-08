package com.github.enesusta.validator.tru;

import com.github.enesusta.validator.core.FieldValidator;

import java.lang.reflect.Field;

public final class TrueFieldValidator implements FieldValidator {

    private final Object object;

    public TrueFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {
        field.setAccessible(true);
        final boolean bool = (boolean) field.get(object);
        return bool;
    }
}
