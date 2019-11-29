package net.enesusta.validator.core;

import net.enesusta.validator.email.EmailFieldValidator;
import net.enesusta.validator.max.MaxFieldValidator;
import net.enesusta.validator.min.MinFieldValidator;
import net.enesusta.validator.negative.NegativeFieldValidator;
import net.enesusta.validator.nonnull.NonNullFieldValidator;
import net.enesusta.validator.positive.PositiveFieldValidator;
import net.enesusta.validator.size.SizeFieldValidator;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class DefaultValidator implements Validator {

    @Override
    public final boolean isValid(final Object object) throws IllegalAccessException {

        final Class<?> clazz = object.getClass();
        final Field[] fields = clazz.getDeclaredFields();

        final FieldValidator nullValidator = new NonNullFieldValidator(object);
        final FieldValidator positiveValidator = new PositiveFieldValidator(object);
        final FieldValidator negativeValidator = new NegativeFieldValidator(object);
        final FieldValidator sizeValidator = new SizeFieldValidator(object);
        final FieldValidator maxValidator = new MaxFieldValidator(object);
        final FieldValidator minValidator = new MinFieldValidator(object);
        final FieldValidator emailValidator = new EmailFieldValidator(object);


        boolean[] valid = prepareValidationArray();
        boolean[] nullBooleans = prepareValidationArray();
        boolean[] positiveBooleans = prepareValidationArray();
        boolean[] negativeBooleans = prepareValidationArray();
        boolean[] sizeBooleans = prepareValidationArray();
        boolean[] maxBooleans = prepareValidationArray();
        boolean[] minBooleans = prepareValidationArray();
        boolean[] emailBooleans = prepareValidationArray();


        byte counter = (byte) 0;
        for (Field field : fields) {

            field.setAccessible(true);
            if (isAnnotationPresentWithNonNullAnnotation(field))
                nullBooleans[counter] = nullValidator.isFieldValid(field);
            if (isAnnotationPresentWithPositiveAnnotation(field))
                positiveBooleans[counter] = positiveValidator.isFieldValid(field);
            if (isAnnotationPresentWithNegativeAnnotation(field))
                negativeBooleans[counter] = negativeValidator.isFieldValid(field);
            if (isAnnotationPresentWithSizeAnnotation(field))
                sizeBooleans[counter] = sizeValidator.isFieldValid(field);
            if (isAnnotationPresentWithMaxAnnotation(field))
                maxBooleans[counter] = maxValidator.isFieldValid(field);
            if (isAnnotationPresentWithMinAnnotation(field))
                minBooleans[counter] = minValidator.isFieldValid(field);
            if (isAnnotationPresentWithEmailAnnotation(field))
                emailBooleans[counter] = emailValidator.isFieldValid(field);

            counter++;
        }

        valid[0] = hasAnyFalse(nullBooleans);
        valid[1] = hasAnyFalse(positiveBooleans);
        valid[2] = hasAnyFalse(negativeBooleans);
        valid[3] = hasAnyFalse(sizeBooleans);
        valid[4] = hasAnyFalse(maxBooleans);
        valid[5] = hasAnyFalse(minBooleans);
        valid[6] = hasAnyFalse(emailBooleans);

        return hasAnyFalse(valid);
    }

    private boolean[] prepareValidationArray() {
        boolean[] booleans = new boolean[10];
        Arrays.fill(booleans,true);
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
