package com.github.enesusta.validator.feature;

import com.github.enesusta.validator.core.DefaultValidator;
import com.github.enesusta.validator.core.Validator;

public class FeatureMain {

    public static void main(String[] args) throws IllegalAccessException {

        Bean bean = new Bean();
        bean.setInstance("enes");

        Validator validator = new DefaultValidator();
        validator.isValid(bean);

    }

    static class Bean {
        @Feature
        private String instance;

        public void setInstance(String instance) {
            this.instance = instance;
        }
    }
}
