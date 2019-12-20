package com.github.enesusta.validator.email;

import com.github.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    private Validator validator;

    @BeforeEach
    void before() {
        validator = new EmailValidator();
    }

    @Test
    void valid_email_falseCase() throws IllegalAccessException {
        EmailBean bean = new EmailBean();
        bean.setEmailField("enesusta.com");
        assertFalse(validator.isValid(bean));
    }

    @Test
    void valid_email_trueCase() throws IllegalAccessException {
        EmailBean bean = new EmailBean();
        bean.setEmailField("enesusta@email.com");
        assertTrue(validator.isValid(bean));
    }
}
