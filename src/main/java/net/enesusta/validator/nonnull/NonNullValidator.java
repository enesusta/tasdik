package net.enesusta.validator.nonnull;

import net.enesusta.validator.core.Validator;

import java.lang.reflect.Field;

public class NonNullValidator implements Validator {
    @Override
    public boolean isValid(Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        boolean valid = true;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NonNull.class)) {
                    if (field.get(object) == null &&
                        field.get(object).equals(0)) {
                        valid = false;
                    }
                }
            } catch (NullPointerException e) {

            }
        }


        return valid;
    }
}
