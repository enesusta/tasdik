package com.github.enesusta.tasdik.regex;

import com.github.enesusta.tasdik.core.FieldValidator;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexFieldValidator implements FieldValidator {

    private final Object object;

    public RegexFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {

        field.setAccessible(true);
        boolean valid = true;

        try {

            final String string = (String) field.get(object);
            final Regex regex = field.getAnnotation(Regex.class);
            final Pattern pattern = Pattern.compile(regex.pattern());
            final Matcher matcher = pattern.matcher(string);
            valid = matcher.find();

        } catch (final NullPointerException | ClassCastException e) {
            valid = false;
        }

        return valid;
    }
}
