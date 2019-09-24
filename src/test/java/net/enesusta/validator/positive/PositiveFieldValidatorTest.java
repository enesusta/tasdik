package net.enesusta.validator.positive;

import net.enesusta.validator.core.Bean;
import net.enesusta.validator.core.FieldValidator;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PositiveFieldValidatorTest {

    private Bean bean;
    private FieldValidator fieldValidator;

    @BeforeEach
    void before() {
        bean = new PositiveBean();
        fieldValidator = new PositiveFieldValidator(bean.get());
    }


}
