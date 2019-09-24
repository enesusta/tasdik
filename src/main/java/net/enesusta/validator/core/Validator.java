package net.enesusta.validator.core;

import net.enesusta.validator.nonnull.NonNull;
import net.enesusta.validator.positive.Positive;

import java.io.Serializable;
import java.lang.reflect.Field;

public interface Validator extends AnnotationValidator {
    boolean isValid(Object object) throws IllegalAccessException;
}
