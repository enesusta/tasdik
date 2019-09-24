package net.enesusta.validator.core;

import java.io.Serializable;
import java.lang.reflect.Field;

public interface Validator {
    boolean isValid() throws IllegalAccessException;
}
