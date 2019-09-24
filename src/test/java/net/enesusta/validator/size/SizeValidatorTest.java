package net.enesusta.validator.size;

import net.enesusta.validator.core.Validator;
import org.junit.jupiter.api.BeforeEach;

public class SizeValidatorTest {

    private SizeBean bean;
    private Validator validator;

    @BeforeEach
    void before() {
        bean = new SizeBean();
        validator = new SizeValidator();
    }

}
