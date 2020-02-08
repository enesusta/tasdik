package com.github.enesusta.validator.core;

public interface Validator {
    boolean isValid(Object object) throws IllegalAccessException;

    default boolean hasAny(boolean[] arr) {
        boolean valid = true;
        for (boolean b : arr) {
            if (!b) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
