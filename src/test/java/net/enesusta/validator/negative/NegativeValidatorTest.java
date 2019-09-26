package net.enesusta.validator.negative;

import net.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NegativeValidatorTest {

    private Validator validator;

    @BeforeEach
    void before() {
        validator = new NegativeValidator();
    }

    @Test
    void negative_int_test() throws IllegalAccessException {
        NegativeBean bean = new NegativeBean();
        bean.setAnInt(-15);
        assertTrue(validator.isValid(bean));
        bean.setAnInt(15);
        assertFalse(validator.isValid(bean));
    }

    @Test
    void negative_floating_test() throws IllegalAccessException {
        NegativeBean bean = new NegativeBean();
        bean.setaFloat(-5.3f);
        assertTrue(validator.isValid(bean));
        bean.setaFloat(3.2f);
        bean.setAnInt(3);
        assertFalse(validator.isValid(bean));
    }

}
