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
                number = (Number) validateableObject;
                final Size size = field.getAnnotation(Size.class);
                final int min = size.min();
                final int max = size.max();
                valid = number.intValue() > min && number.intValue() < max;

                Size sizeStr = field.getAnnotation(Size.class);
                string = (String) validateableObject;
                final int minStr = size.min();
                final int maxStr = size.max();
                System.out.println("min = " + minStr);
                System.out.println("max = " + maxStr);
                System.out.println("string.length() = " + string.length());
                valid = string.length() >= minStr && string.length() <= maxStr;

            } catch (NullPointerException e) {
                valid = false;
            } catch (NumberFormatException e) {
                valid = false;
            } catch (ClassCastException e) {
                valid = false;
            }

        }
        return valid;
    }
}
