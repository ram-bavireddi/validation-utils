package com.epam.utils;

import com.epam.utils.validation.*;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PasswordValidatorTest {

    private static PasswordValidator passwordValidator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void passwordIsValid() throws ValidationException {
        ValidationException validationException = null;
        try {
            passwordValidator.validate("ram123");
        } catch (ValidationException ex) {
            validationException = ex;
        }
        assertNull("No ValidationException", validationException);
    }

    @Test
    public void passwordIsNull() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(NotNullValidation.VALIDATION_FAILED_MESSAGE);
        passwordValidator.validate(null);
    }

    @Test
    public void passwordWithNoMinimumLength() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(this.expectedMessage());
        passwordValidator.validate("ram");
    }

    @Test
    public void passwordWithMaxLengthExceeded() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(this.expectedMessage());
        passwordValidator.validate("ramubavireddi");
    }

    @Test
    public void passwordHasImmediateSequenceOfSameChars() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(NoImmediateSameSequenceValidation.VALIDATION_FAILED_MESSAGE);
        passwordValidator.validate("pass1pass1");
    }

    @Test
    public void passwordDoesNotMatchRegEx() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(PatternValidation.VALIDATION_FAILED_MESSAGE);
        passwordValidator.validate("password");
    }

    private String expectedMessage() {
        return String.format(
                LengthValidation.VALIDATION_FAILED_MESSAGE,
                LengthValidation.DEFAULT_MIN_LENGTH,
                LengthValidation.DEFAULT_MAX_LENGTH
        );
    }
}
