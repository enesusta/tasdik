package net.enesusta.validator.core;

import net.enesusta.validator.email.Email;
import net.enesusta.validator.max.Max;
import net.enesusta.validator.min.Min;
import net.enesusta.validator.negative.Negative;
import net.enesusta.validator.nonnull.NonNull;
import net.enesusta.validator.positive.Positive;
import net.enesusta.validator.size.Size;

import java.lang.reflect.Field;

@SuppressWarnings("checkstyle:LineLength")
public interface AnnotationValidator {
    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    default boolean isAnnotationPresentWithNonNullAnnotation(final Field field) {
        return field.isAnnotationPresent(NonNull.class);
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    default boolean isAnnotationPresentWithPositiveAnnotation(final Field field) {
        return field.isAnnotationPresent(Positive.class);
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    default boolean isAnnotationPresentWithSizeAnnotation(final Field field) {
        return field.isAnnotationPresent(Size.class);
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    default boolean isAnnotationPresentWithMinAnnotation(final Field field) {
        return field.isAnnotationPresent(Min.class);
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    default boolean isAnnotationPresentWithMaxAnnotation(final Field field) {
        return field.isAnnotationPresent(Max.class);
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    default boolean isAnnotationPresentWithNegativeAnnotation(final Field field) {
        return field.isAnnotationPresent(Negative.class);
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    default boolean isAnnotationPresentWithEmailAnnotation(final Field field) {
        return field.isAnnotationPresent(Email.class);
    }
}
