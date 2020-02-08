package com.github.enesusta.validator.core;

import com.github.enesusta.validator.fals.False;
import com.github.enesusta.validator.fals.FalseFieldValidator;
import com.github.enesusta.validator.tru.True;
import com.github.enesusta.validator.tru.TrueFieldValidator;
import com.github.enesusta.validator.email.Email;
import com.github.enesusta.validator.email.EmailFieldValidator;
import com.github.enesusta.validator.max.Max;
import com.github.enesusta.validator.max.MaxFieldValidator;
import com.github.enesusta.validator.min.Min;
import com.github.enesusta.validator.min.MinFieldValidator;
import com.github.enesusta.validator.negative.Negative;
import com.github.enesusta.validator.negative.NegativeFieldValidator;
import com.github.enesusta.validator.positive.Positive;
import com.github.enesusta.validator.positive.PositiveFieldValidator;
import com.github.enesusta.validator.regex.Regex;
import com.github.enesusta.validator.regex.RegexFieldValidator;
import com.github.enesusta.validator.size.Size;
import com.github.enesusta.validator.size.SizeFieldValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FieldContext {

    private static FieldContext instance = null;
    private Map<Class<? extends Annotation>, FieldValidator> contextMap = new HashMap<>(9);

    private FieldContext(final Object o) {
        initialize(o);
    }

    private void initialize(final Object object) {
        contextMap.put(Email.class, new EmailFieldValidator(object));
        contextMap.put(Min.class, new MinFieldValidator(object));
        contextMap.put(Max.class, new MaxFieldValidator(object));
        contextMap.put(Negative.class, new NegativeFieldValidator(object));
        contextMap.put(Positive.class, new PositiveFieldValidator(object));
        contextMap.put(Regex.class, new RegexFieldValidator(object));
        contextMap.put(Size.class, new SizeFieldValidator(object));
        contextMap.put(True.class, new TrueFieldValidator(object));
        contextMap.put(False.class, new FalseFieldValidator(object));
    }

    public static FieldContext getInstance(final Object o) {
        if (instance == null)
            instance = new FieldContext(o);
        return instance;
    }

    public boolean isValid(final Field field) throws IllegalAccessException {
        boolean isValid = true;
        for (Annotation annotation : field.getAnnotations())
            if (!contextMap.get(annotation.annotationType()).isFieldValid(field))
                isValid = false;
        return isValid;
    }

}
