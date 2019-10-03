package net.enesusta.validator.core;

import net.enesusta.validator.core.log.LogUtils;
import net.enesusta.validator.email.EmailFieldValidator;
import net.enesusta.validator.max.MaxFieldValidator;
import net.enesusta.validator.min.MinFieldValidator;
import net.enesusta.validator.negative.NegativeFieldValidator;
import net.enesusta.validator.nonnull.NonNull;
import net.enesusta.validator.nonnull.NonNullFieldValidator;
import net.enesusta.validator.positive.Positive;
import net.enesusta.validator.positive.PositiveFieldValidator;
import net.enesusta.validator.size.SizeFieldValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DefaultValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        boolean valid[] = prepareValidationArray();

        final FieldValidator nullValidator = new NonNullFieldValidator(object);
        final FieldValidator positiveValidator = new PositiveFieldValidator(object);
        final FieldValidator negativeValidator = new NegativeFieldValidator(object);
        final FieldValidator sizeValidator = new SizeFieldValidator(object);
        final FieldValidator maxValidator = new MaxFieldValidator(object);
        final FieldValidator minValidator = new MinFieldValidator(object);
        final FieldValidator emailValidator = new EmailFieldValidator(object);


        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase("stduid")) {
                final Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : annotations) {
                    System.out.println(annotation);
                }
            }

            if (isAnnotationPresentWithNonNullAnnotation(field))
                valid[0] = nullValidator.isFieldValid(field);
            else if (isAnnotationPresentWithPositiveAnnotation(field))
                valid[1] = positiveValidator.isFieldValid(field);
            else if (isAnnotationPresentWithNegativeAnnotation(field))
                valid[2] = negativeValidator.isFieldValid(field);
            else if (isAnnotationPresentWithSizeAnnotation(field))
                valid[3] = sizeValidator.isFieldValid(field);
            else if (isAnnotationPresentWithMaxAnnotation(field)) {
                valid[4] = maxValidator.isFieldValid(field);
                System.out.println("default is : " + valid[4]);
            } else if (isAnnotationPresentWithMinAnnotation(field))
                valid[5] = minValidator.isFieldValid(field);
            else if (isAnnotationPresentWithEmailAnnotation(field))
                valid[6] = emailValidator.isFieldValid(field);
        }

        return hasAnyFalse(valid);
    }

    private boolean[] prepareValidationArray() {

        boolean[] booleans = new boolean[7];
        IntStream.range(0, 7).forEach(i -> {
            booleans[i] = true;
        });

        return booleans;
    }

    private boolean hasAnyFalse(final boolean[] booleans) {
        boolean valid = true;
        for (boolean aBoolean : booleans) {
            if (!aBoolean) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
