package com.github.enesusta.validator.email;

import com.github.enesusta.validator.core.FieldValidator;

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
            System.out.println("fieldString = " + fieldString);

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
