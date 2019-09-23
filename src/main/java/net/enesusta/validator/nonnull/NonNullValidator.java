package net.enesusta.validator.nonnull;

import net.enesusta.validator.core.Validator;
import net.enesusta.validator.core.log.LogUtils;

import java.io.Serializable;
import java.lang.reflect.Field;

public class NonNullValidator implements Validator {
    @Override
    public boolean isValid(Serializable serializable) throws IllegalAccessException {

        final Class<?> clazz = serializable.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        boolean valid = true;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NonNull.class)) {
                    NonNull nonNull = field.getAnnotation(NonNull.class);
                    if (nonNull.ignore()) continue;
                    field.get(serializable);
                }
            } catch (NullPointerException e) {
                LogUtils.flush(String.format("%s is null", field.getName()));
                valid = false;
            }
        }

        return valid;
    }
}
