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
            if (validateableObject instanceof Number) {
                block:
                {
                    number = (Number) validateableObject;
                    if (number.intValue() == 0) {
                        valid = true;
                        break block;
                    }
                    System.out.println("evet number bu");
                    final Size size = field.getAnnotation(Size.class);
                    final int min = size.min();
                    final int max = size.max();
                    System.out.println(min);
                    System.out.println(max);
                    System.out.println(number.intValue());
                    valid = number.intValue() >= min && number.intValue() <= max;
                    System.out.println("valid1 = " + valid);
                    System.out.println("============");
                }
            } else if (validateableObject instanceof String) {
                block:
                {
                    System.out.println("evet string bu");
                    Size size = field.getAnnotation(Size.class);
                    string = (String) validateableObject;
                    if (string.isBlank()) {
                        valid = true;
                        break block;
                        System.out.println("girdi");
                    }
                    final int minStr = size.min();
                    final int maxStr = size.max();
                    System.out.println("min = " + minStr);
                    System.out.println("max = " + maxStr);
                    System.out.println("string.length() = " + string.length());
                    valid = string.length() >= minStr && string.length() <= maxStr;
                }
            }
            System.out.println("va = " + valid);
        } catch (NullPointerException e) {
            valid = false;
        }

        return valid;
    }
}
