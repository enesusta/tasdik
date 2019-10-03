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

            System.out.printf("Field name is : %s \n", field.getName());
            field.setAccessible(true);
            if (isAnnotationPresentWithNonNullAnnotation(field)) {
                valid[0] = nullValidator.isFieldValid(field);
                System.out.printf("Null annotation state : %b \n", valid[0]);
            }
            if (isAnnotationPresentWithPositiveAnnotation(field)) {
                valid[1] = positiveValidator.isFieldValid(field);
                System.out.printf("Positive annotation state :%b \n", valid[1]);
            }
            if (isAnnotationPresentWithNegativeAnnotation(field)) {
                valid[2] = negativeValidator.isFieldValid(field);
                System.out.printf("Negative annotation state :%b \n", valid[2]);
            }
            if (isAnnotationPresentWithSizeAnnotation(field)) {
                valid[3] = sizeValidator.isFieldValid(field);
                System.out.printf("Size annotation state :%b \n", valid[3]);
            }
            if (isAnnotationPresentWithMaxAnnotation(field)) {
                valid[4] = maxValidator.isFieldValid(field);
                System.out.println("bu = :" + valid[4]);
                System.out.printf("Max annotation state :%b \n", valid[4]);
            }
            if (isAnnotationPresentWithMinAnnotation(field)) {
                valid[5] = minValidator.isFieldValid(field);
                System.out.printf("Min annotation state : %b \n", valid[5]);
            }
            if (isAnnotationPresentWithEmailAnnotation(field)) {
                valid[6] = emailValidator.isFieldValid(field);
                System.out.printf("Email annotation state :%b \n", valid[6]);
            }

            System.out.println("bu 1 "  + valid[4]);

            System.out.println("\n\n\nAYRIM ======================================= AYRIM\n\n\n");
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
            System.out.println("booleans : " + aBoolean);
            if (!aBoolean) {
                valid = false;
                break;
            }
        }
        System.out.println("has any false : " + valid);
        System.out.println("valid[4] : " + booleans[4]);
        return valid;
    }
}
