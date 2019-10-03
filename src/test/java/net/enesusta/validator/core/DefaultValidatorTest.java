package net.enesusta.validator.core;

import org.junit.jupiter.api.BeforeAll;
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
        System.out.println("valid1 = " + valid);
        assertFalse(valid);

        student.setStduID(9);

        boolean valid2 = validator.isValid(student);
        System.out.println("valid2 = " + valid2);
        assertTrue(valid2);

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

        assertTrue(validator.isValid(student));
    }


}
