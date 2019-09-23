package net.enesusta.validator.core;

import java.io.Serializable;

public class ValidatorManager {

    private Validator validator;

    public ValidatorManager(final Validator validator) {
        this.validator = validator;
    }

    public boolean isValid(final Object object) {
        boolean status = false;
        try {
            status = validator.isValid(object);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
