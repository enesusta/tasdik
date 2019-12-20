package com.github.enesusta.validator.regex;

import com.github.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexValidatorTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        validator = new RegexValidator();
    }

    @Test
    void test01() throws Exception {

        RegexBean regexBean = new RegexBean();
        regexBean.setTest1("123");
        assertTrue(validator.isValid(regexBean));

    }

}
