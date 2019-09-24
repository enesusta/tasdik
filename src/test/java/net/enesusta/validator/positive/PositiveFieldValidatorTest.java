package net.enesusta.validator.positive;

import net.enesusta.validator.core.Bean;
import net.enesusta.validator.core.FieldValidator;
import net.enesusta.validator.core.PositiveValidator;
import net.enesusta.validator.core.Validator;
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
    }

    @Test
    void valid_short() throws IllegalAccessException {
        bean.setaShort((short) -30000);
        assertFalse(validator.isValid(bean));
    }

    

}
