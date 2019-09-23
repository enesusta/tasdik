package net.enesusta.validator.nonnull;

import net.enesusta.validator.core.Validator;
import net.enesusta.validator.core.ValidatorManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class NonNullTest {

    private SampleBean sampleBean;
    private Validator validator;
    private ValidatorManager manager;

    @BeforeEach
    void before() {
        sampleBean = new SampleBean();
        validator = new NonNullValidator();
        manager = new ValidatorManager(validator);
    }

    @Test
    void bean_string_null_test() {
        assertFalse(manager.isValid(sampleBean));
    }

    @Test
    void bean_static_string_null_test() {
        assertFalse(manager.isValid(sampleBean));
    }

    @Test
    void bean_int_null_test() {
        assertFalse(manager.isValid(sampleBean));
        System.out.println("test");
    }

}
