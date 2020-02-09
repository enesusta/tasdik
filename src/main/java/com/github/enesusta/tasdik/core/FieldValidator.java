package com.github.enesusta.tasdik.core;

import java.lang.reflect.Field;

public interface FieldValidator {
    boolean isFieldValid(Field field) throws IllegalAccessException;
}
