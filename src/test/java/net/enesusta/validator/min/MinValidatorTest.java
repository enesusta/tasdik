package net.enesusta.validator.min;

import net.enesusta.validator.core.Validator;
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
    void valid_byte() throws IllegalAccessException {
        bean.setaByte((byte) 3);
        assertFalse(validator.isValid(bean));
        bean.setaShort((short)2);
        assertFalse(validator.isValid(bean));
    }

}
