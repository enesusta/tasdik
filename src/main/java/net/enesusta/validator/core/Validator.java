package net.enesusta.validator.core;

import java.io.Serializable;
import java.lang.reflect.Field;

public interface Validator {
    boolean isValid(Object object) throws IllegalAccessException;
}
