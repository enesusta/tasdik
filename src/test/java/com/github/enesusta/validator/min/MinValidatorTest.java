package com.github.enesusta.validator.min;

import com.github.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinValidatorTest {

    private MinBean bean;
    private Validator validator;

    @BeforeEach
    void before() {
        bean = new MinBean();
        validator = new MinValidator();
    }

    @Test
    void valid_min_byte() throws IllegalAccessException {
        bean.setaByte((byte) 3);
        assertFalse(validator.isValid(bean));
        bean.setaShort((short) 2);
        assertFalse(validator.isValid(bean));
    }

    @Test
    void valid_min_int() throws IllegalAccessException {
        MinBean minBean = new MinBean();
        minBean.setAnInt(10);
        assertTrue(validator.isValid(minBean));
        minBean.setAnInt(5);
        assertFalse(validator.isValid(minBean));
    }

    @Test
    void valid_min_long() throws IllegalAccessException {
        MinBean minBean = new MinBean();
        minBean.setaLong(3L);
        assertFalse(validator.isValid(minBean));
    }

    @Test
    void valid_min_floating() throws IllegalAccessException {
        MinBean minBean = new MinBean();
        minBean.setaFloat(2.3f);
        minBean.setaDouble(3.5d);
        assertFalse(validator.isValid(minBean));
        minBean.setaFloat(6.7f);
        minBean.setaDouble(8.132d);
        assertTrue(validator.isValid(minBean));
        minBean.setString("12345");
        assertTrue(validator.isValid(minBean));
    }

}
