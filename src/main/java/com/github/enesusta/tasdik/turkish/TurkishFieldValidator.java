package com.github.enesusta.tasdik.turkish;

import com.github.enesusta.tasdik.core.FieldValidator;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class TurkishFieldValidator implements FieldValidator {

    private final Object object;

    private TurkishFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {
        field.setAccessible(true);

        return false;
    }
}
