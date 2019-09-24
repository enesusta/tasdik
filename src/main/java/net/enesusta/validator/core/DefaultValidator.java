package net.enesusta.validator.core;

import net.enesusta.validator.core.log.LogUtils;
import net.enesusta.validator.nonnull.NonNull;
import net.enesusta.validator.nonnull.NonNullFieldValidator;
import net.enesusta.validator.positive.PositiveFieldValidator;

import java.lang.reflect.Field;

public class DefaultValidator implements Validator {

    @Override
    public boolean isValid(Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        boolean valid = true;

        final FieldValidator nullValidator = new NonNullFieldValidator(object);
        final FieldValidator positiveValidator = new PositiveFieldValidator(object);

        for (Field field : fields) {
            field.setAccessible(true);
            
        }

        return valid;
    }
}
