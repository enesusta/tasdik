package com.github.enesusta.validator.positive;

import com.github.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveFieldValidatorTest {

    private PositiveBean bean;
    private Validator validator;

    @BeforeEach
    void before() {
        bean = new PositiveBean();
        validator = new PositiveValidator();
    }

    @Test
    void valid_byte() throws IllegalAccessException {
        bean.setaByte((byte) -120);
        assertFalse(validator.isValid(bean));
        bean.setaByte((byte) 34);
        assertTrue(validator.isValid(bean));
    }

    @Test
    void valid_short() throws IllegalAccessException {
        bean.setaShort((short) -30000);
        assertFalse(validator.isValid(bean));
        bean.setaShort((short) 1323);
        assertTrue(validator.isValid(bean));
    }

    @Test
    void valid_int() throws IllegalAccessException {
        bean.setAnInt(-34123);
        assertFalse(validator.isValid(bean));
        bean.setAnInt(132);
        assertTrue(validator.isValid(bean));
    }


}
