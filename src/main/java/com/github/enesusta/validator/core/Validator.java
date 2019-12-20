package com.github.enesusta.validator.core;

public interface Validator extends AnnotationValidator {
    boolean isValid(Object object) throws IllegalAccessException;
}
