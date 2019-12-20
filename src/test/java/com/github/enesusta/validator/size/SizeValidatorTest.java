package com.github.enesusta.validator.size;

import com.github.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SizeValidatorTest {

    private SizeBean bean;
    private Validator validator;

    @BeforeEach
    void before() {
        bean = new SizeBean();
        validator = new SizeValidator();
    }


    @Test
    void valid_int() throws IllegalAccessException {
        SizeBean sizeBean = new SizeBean();
        sizeBean.setAnInt(13);
        assertFalse(validator.isValid(sizeBean));
        sizeBean.setAnInt(17);
        assertTrue(validator.isValid(sizeBean));
        sizeBean.setAnInt(36);
        assertFalse(validator.isValid(sizeBean));
    }

    @Test
    void valid_floating_numbers() throws IllegalAccessException {
        bean.setaFloat(3.2f);
        bean.setaDouble(4.3d);
        assertFalse(validator.isValid(bean));
    }


    @Test
    void valid_string() throws IllegalAccessException {
        SizeBean sizeBean = new SizeBean();
        sizeBean.setString("a123");
        sizeBean.setString2("a1322312");
        assertFalse(validator.isValid(sizeBean));
        sizeBean.setString("a");
        assertFalse(validator.isValid(sizeBean));
        sizeBean.setString("a323");
        sizeBean.setString2("231");
        assertTrue(validator.isValid(sizeBean));
    }

}
