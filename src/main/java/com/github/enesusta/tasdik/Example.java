package com.github.enesusta.tasdik;


import com.github.enesusta.tasdik.fals.False;
import com.github.enesusta.tasdik.max.Max;
import com.github.enesusta.tasdik.min.Min;
import com.github.enesusta.tasdik.negative.Negative;
import com.github.enesusta.tasdik.nonnull.NonNull;
import com.github.enesusta.tasdik.positive.Positive;
import com.github.enesusta.tasdik.regex.Regex;
import com.github.enesusta.tasdik.size.Size;
import com.github.enesusta.tasdik.tru.True;
import com.github.enesusta.tasdik.validator.DefaultValidator;
import com.github.enesusta.tasdik.validator.Validator;

public class Example {

    public static class Bean {

        @False
        private boolean mustBeFalse;

        @True
        private boolean mustBeTrue;

        @Max(value = 10)
        private int mustBeAMaximumOf10;

        @Min(value = 5)
        private int mustBeAMin5;

        @Negative
        private int mustBeNegative;

        @Positive
        private int mustBePositive;

        @NonNull
        private Object mustBeNonNull;

        @Size(min = 5, max = 10)
        private String numberOfCharactersMustBeBetween5and10;

        @Regex(pattern = "\\d+")
        private String mustBeDigit;

        /**
         * setter/getter/constructor and other stuffs
         */
    }

    public static void main(String[] args) throws IllegalAccessException {

        Bean bean = new Bean();
        /**
         * setter / getter etc on your bean
         */

        Validator validator = DefaultValidator.getInstance();
        boolean isValid = validator.isValid(bean);
    }

}
