package net.enesusta.validator.email;

import net.enesusta.validator.core.FieldValidator;

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
        }

        return valid;
    }

    private boolean isStringEmail(final String string) {
        return string.indexOf("@") > 0;
    }

}
