package net.enesusta.validator.nonnull;

import net.enesusta.validator.core.FieldValidator;
import net.enesusta.validator.core.Validator;
import net.enesusta.validator.core.log.LogUtils;

import java.io.Serializable;
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
