package com.github.enesusta.validator.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultValidatorTest {

    private Validator validator;

    @BeforeEach
    void before() {
        validator = new DefaultValidator();
    }

    @Test
    void complexBeanTest_posivite() throws Exception {

        Student student = new Student();
        student.setStduID(11);
        student.setStduName("enes");
        student.setStduSurname("usta");
        student.setStduAddress("testtesttsetestettest");
        student.setStduNote((byte) 80);
        student.setStduEmail("a@com");

        boolean valid = validator.isValid(student);
        assertTrue(valid);

        student.setStduName("a1132123123321");
        assertFalse(validator.isValid(student));

        student.setStduName("12345");
        assertTrue(validator.isValid(student));

        student.setStduNote((byte) 120);
        assertFalse(validator.isValid(student));

    }

    @Test
    void complexBeanTest_negative() throws Exception {

        Student student = new Student();
        student.setStduID(-5);
        student.setStduName("enes");
        student.setStduSurname("usta");
        student.setStduAddress("testtesttsetestettest");
        student.setStduNote((byte) 80);
        student.setStduEmail("test@com");

        assertFalse(validator.isValid(student));
    }


}
