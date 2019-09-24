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

        try {
            validateableObject = field.get(object);
            if (Number.class.isInstance(validateableObject)) {
                block:
                {
                    number = (Number) validateableObject;
                    if (number.intValue() == 0)
                        break block;
                    final Size size = field.getAnnotation(Size.class);
                    final int min = size.min();
                    final int max = size.max();
                    valid = number.intValue() >= min && number.intValue() <= max;
                }
            } else if (String.class.isInstance(validateableObject)) {
                block:
                {
                    string = (String) validateableObject;
                    if (string.isEmpty())
                        break block;
                    Size size = field.getAnnotation(Size.class);
                    final int minStr = size.min();
                    final int maxStr = size.max();
                    valid = string.length() >= minStr && string.length() <= maxStr;
                }
            }
        } catch (NullPointerException e) {
            valid = false;
        }

        System.out.println(valid);
        return valid;
    }
}
