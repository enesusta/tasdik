package net.enesusta.validator.max;

import net.enesusta.validator.core.FieldValidator;

import java.lang.reflect.Field;

public class MaxFieldValidator implements FieldValidator {

    private Object object;

    public MaxFieldValidator(final Object object) {
        this.object = object;
    }

    @Override
    public boolean isFieldValid(Field field) throws IllegalAccessException {

        field.setAccessible(true);
        boolean valid = true;
        Object validateableObject = null;

        try {
            validateableObject = field.get(object);
            if (Number.class.isInstance(validateableObject)) {
                block:
                {
                    final Number number = (Number) validateableObject;
                    if (number.intValue() == 0)
                        break block;
                    final Max annotation = field.getAnnotation(Max.class);
                    valid = number.intValue() <= annotation.max();
                }
            } else if (String.class.isInstance(validateableObject)) {
                block:
                {
                    final String string = (String) validateableObject;
                    if (string.isEmpty()) break block;
                    final Max annotation = field.getAnnotation(Max.class);
                    valid = string.length() <= annotation.max();
                }
            }

        } catch (NullPointerException e) {
            valid = false;
        }
        return valid;
    }
}
