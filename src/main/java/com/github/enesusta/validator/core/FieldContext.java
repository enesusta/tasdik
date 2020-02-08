package com.github.enesusta.validator.core;

import com.github.enesusta.validator.email.Email;
import com.github.enesusta.validator.email.EmailFieldValidator;
import com.github.enesusta.validator.feature.Feature;
import com.github.enesusta.validator.feature.FeatureAnotherFieldValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FieldContext {

    private static FieldContext instance = null;
    private Map<Class<? extends Annotation>, AnotherFieldValidator> contextMap = new HashMap<>();

    private FieldContext() {
        initialize();
    }

    private void initialize() {
        contextMap.put(Feature.class, new FeatureAnotherFieldValidator());
    }

    public static FieldContext getInstance() {
        if (instance == null)
            instance = new FieldContext();
        return instance;
    }

    public boolean isValid(final Field field) {
        boolean isValid = true;
        for (Annotation annotation : field.getAnnotations())
            if (!contextMap.get(annotation.annotationType()).isFieldValid())
                isValid = false;

        return isValid;
    }

}
