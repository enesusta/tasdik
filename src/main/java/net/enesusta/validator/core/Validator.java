package net.enesusta.validator.core;

import java.io.Serializable;

public interface Validator {
    <A extends Serializable> boolean isValid(A a) throws IllegalAccessException;
}
