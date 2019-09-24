package net.enesusta.validator.core;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ValidatorManager {

    private Validator validator;

    public ValidatorManager(final Validator validator) {
        this.validator = validator;
    }

    public boolean isValid(final Field field) {
        boolean status = false;
        try {
            status = validator.isValid(field);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
