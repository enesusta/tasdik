package net.enesusta.validator.core;

import net.enesusta.validator.nonnull.NonNull;
import net.enesusta.validator.positive.Positive;

import java.lang.reflect.Field;

public interface AnnotationValidator {
    default boolean isAnnotationPresentWithNonNull(final Field field) {
        return field.isAnnotationPresent(NonNull.class);
    }
    default boolean isAnnotationPresentWithPositive(final Field field) {
        return field.isAnnotationPresent(Positive.class);
    }
}
