package com.github.enesusta.validator.max;

import com.github.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxValidatorTest {

    private Validator validator;

    @BeforeEach
    void before() {
        validator = new MaxValidator();
    }

    @Test
    void valid_max_int() throws IllegalAccessException {
        MaxBean bean = new MaxBean();
        bean.setAnInt(14);
        assertTrue(validator.isValid(bean));
        bean.setAnInt(17);
        assertFalse(validator.isValid(bean));
    }

    @Test
    void valid_max_string() throws IllegalAccessException {
        MaxBean bean = new MaxBean();
        bean.setString("1343");
        assertTrue(validator.isValid(bean));
        bean.setString("1321132");
        assertFalse(validator.isValid(bean));
    }

    @Test
    void valid_max_floating() throws IllegalAccessException {
        MaxBean bean = new MaxBean();
        bean.setaFloat(2.3f);
        assertTrue(validator.isValid(bean));
        bean.setaFloat(8.3f);
        assertFalse(validator.isValid(bean));
        bean.setAnInt(1321);
        assertFalse(validator.isValid(bean));
    }

}
