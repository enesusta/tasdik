package com.github.enesusta.tasdik.nonnull;

import com.github.enesusta.tasdik.core.FieldValidator;

import java.lang.reflect.Field;
import java.util.Optional;

public class NonNullFieldValidator implements FieldValidator {

    private Object serializableObject;

    public NonNullFieldValidator(final Object serializableObject) {
        this.serializableObject = serializableObject;
    }


    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {

        field.setAccessible(true);
        boolean valid = true;
        Object object = null;

        final Optional<Field> fieldOptional = Optional.ofNullable(field);
        if (fieldOptional.isPresent()) {
            try {
                final NonNull nonNull = field.getAnnotation(NonNull.class);
                if (!nonNull.ignore())
                    object = field.get(serializableObject);
                else if (object instanceof Number)
                    valid = !object.equals(0) ? true : false;

            } catch (NullPointerException e) {
                e.printStackTrace();
                valid = false;
            }
        }

        return valid;
    }
}
