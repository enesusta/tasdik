package net.enesusta.validator.core;

import java.io.Serializable;
import java.lang.annotation.Annotation;

public interface Validator {
    <A extends Serializable> boolean isValid(A a) throws IllegalAccessException;
}
