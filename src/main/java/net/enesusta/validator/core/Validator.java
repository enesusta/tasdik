package net.enesusta.validator.core;

import java.io.Serializable;
import java.lang.annotation.Annotation;

public interface Validator {
    boolean isValid(Object object) throws IllegalAccessException;
}
