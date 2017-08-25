package com.epam.utils;

import com.epam.utils.validation.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PasswordValidatorTests {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private PasswordValidator passwordValidator;

    @Test
    public void whenNullPassword() throws ValidationException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(NotNullValidation.VALIDATION_FAILED_MESSAGE);
        passwordValidator.validate(null);
    }

    @Test
    public void whenPasswordLengthNotBetween5And12() throws ValidationException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(LengthValidation.VALIDATION_FAILED_MESSAGE);
        passwordValidator.validate("ram");
    }

    @Test
    public void whenPasswordDoesNotMatchRegEx() throws ValidationException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(PatternValidation.VALIDATION_FAILED_MESSAGE);
        passwordValidator.validate("password");
    }

    @Test
    public void whenPasswordHasImmediateSequenceOfChars() throws ValidationException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(NoImmediateSameSequenceValidation.VALIDATION_FAILED_MESSAGE);
        passwordValidator.validate("pass1pass1");
    }

    @Test
    public void whenPasswordIsValid() throws ValidationException {
        passwordValidator.validate("ram123");
    }
}
