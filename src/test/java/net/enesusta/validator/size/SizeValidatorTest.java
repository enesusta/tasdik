package net.enesusta.validator.size;

import net.enesusta.validator.core.Validator;
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

    /*
        @Test
        void valid_int() throws IllegalAccessException {
            bean.setAnInt(14);
            assertFalse(validator.isValid(bean));
            bean.setAnInt(32);
            assertTrue(validator.isValid(bean));
        }
    */
    @Test
    void valid_string() throws IllegalAccessException {
        bean.setString("test");
        assertTrue(validator.isValid(bean));
        bean.setString("te");
        assertFalse(validator.isValid(bean));
    }

}
