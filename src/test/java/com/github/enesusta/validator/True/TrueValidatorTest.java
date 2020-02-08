package com.github.enesusta.validator.True;

import com.github.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrueValidatorTest {

    private Validator validator;

    @BeforeEach
    void before() {
        validator = new TrueValidator();
    }

    @Test
    void test1() throws Exception {
        TrueBean trueBean = new TrueBean();
        assertFalse(validator.isValid(trueBean));
        trueBean.setSomeLogic(true);
        assertTrue(validator.isValid(trueBean));
    }

}
