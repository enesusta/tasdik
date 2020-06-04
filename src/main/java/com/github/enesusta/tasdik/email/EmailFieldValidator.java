package com.github.enesusta.tasdik.email;

import com.github.enesusta.tasdik.validator.FieldValidator;

import java.lang.reflect.Field;

public class EmailFieldValidator implements FieldValidator {

    private Object object;

    public EmailFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {

        field.setAccessible(true);
        boolean valid = true;

        try {

            final String fieldString = (String) field.get(object);

            block:
            {
                if (fieldString.isEmpty()) break block;
                valid = isStringEmail(fieldString);
            }


        } catch (Exception e) {
            valid = false;
            e.printStackTrace();
        }

        return valid;
    }

    private boolean isStringEmail(final String string) {
        return string.indexOf("@") > 0;
    }

    @Override
    public String toString() {
        return "emailFieldValidator";
    }
}
