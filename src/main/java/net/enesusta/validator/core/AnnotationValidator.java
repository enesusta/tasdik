package net.enesusta.validator.core;

import net.enesusta.validator.max.Max;
import net.enesusta.validator.min.Min;
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

    default boolean isAnnotationPresentWithMinAnnotation(final Field field) {
        return field.isAnnotationPresent(Min.class);
    }

    default boolean isAnnotationPresentWithMaxAnnotation(final Field field) {
        return field.isAnnotationPresent(Max.class);
    }
}
