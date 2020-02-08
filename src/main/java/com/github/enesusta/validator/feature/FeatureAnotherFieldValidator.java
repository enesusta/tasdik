package com.github.enesusta.validator.feature;

import com.github.enesusta.validator.core.AnotherFieldValidator;

public class FeatureAnotherFieldValidator implements AnotherFieldValidator {
    @Override
    public boolean isFieldValid() throws IllegalArgumentException {
        System.out.println("tamam calisiyor amk");
        return false;
    }
}
