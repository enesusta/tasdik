package net.enesusta.validator.core;

import net.enesusta.validator.nonnull.NonNull;
import net.enesusta.validator.positive.Positive;
import net.enesusta.validator.size.Size;

import java.lang.reflect.Field;

public interface AnnotationValidator {
    default boolean isAnnotationPresentWithNonNullAnnotation(final Field field) {
        return field.isAnnotationPresent(NonNull.class);
    }

    default boolean isAnnotationPresentWithPositiveAnnotation(final Field field) {
        return field.isAnnotationPresent(Positive.class);
    }

    default boolean isAnnotationPresentWithSizeAnnotation(final Field field) {
        return field.isAnnotationPresent(Size.class);
    }
}
