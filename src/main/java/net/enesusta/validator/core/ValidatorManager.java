package net.enesusta.validator.core;

import java.io.Serializable;
import java.lang.annotation.Annotation;

public class ValidatorManager {

    private Validator validator;

    public ValidatorManager(final Validator validator) {
        this.validator = validator;
    }

    public boolean isValid(final Serializable serializable) {
        boolean status = false;
        try {
            status = validator.isValid(serializable);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
