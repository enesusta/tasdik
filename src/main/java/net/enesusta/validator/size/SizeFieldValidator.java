package net.enesusta.validator.size;

import net.enesusta.validator.core.FieldValidator;
import net.enesusta.validator.core.Validator;

import java.lang.reflect.Field;
import java.util.Optional;

public class SizeFieldValidator implements FieldValidator {

    private Object object;

    public SizeFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public final boolean isFieldValid(final Field field) throws IllegalAccessException {

        field.setAccessible(true);
        boolean valid = true;

        Number number = null;
        String string = null;
        Object validateableObject = null;

        final Optional<Field> fieldOptional = Optional.ofNullable(field);
        if (fieldOptional.isPresent()) {
            try {
                validateableObject = field.get(object);
                if (validateableObject instanceof Number) {
                    Size size = field.getAnnotation(Size.class);
                    number = (Number) validateableObject;
                    int min = size.min();
                    int max = size.max();
                    valid = number.intValue() > min && number.intValue() < max;
                } else if (validateableObject instanceof String) {
                    Size size = field.getAnnotation(Size.class);
                    string = (String) validateableObject;
                    int min = size.min();
                    int max = size.max();
                    valid = string.length() > min && string.length() < max;
                }
            } catch (NullPointerException e) {
                valid = false;
            }
        }

        return valid;
    }
}
