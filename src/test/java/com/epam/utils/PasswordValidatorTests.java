package com.epam.utils;

import com.epam.utils.validation.PasswordValidator;
import com.epam.utils.validation.ValidationException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PasswordValidatorTests {

    private static PasswordValidator passwordValidator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void whenNullPassword() throws ValidationException {
        thrown.expect(ValidationException.class);
        passwordValidator.validate(null);
    }

    @Test
    public void whenPasswordLengthNotBetween5And12() throws ValidationException {
        thrown.expect(ValidationException.class);
        passwordValidator.validate("ram");
    }

    @Test
    public void whenPasswordDoesNotMatchRegEx() throws ValidationException {
        thrown.expect(ValidationException.class);
        passwordValidator.validate("password");
    }

    @Test
    public void whenPasswordHasImmediateSequenceOfChars() throws ValidationException {
        thrown.expect(ValidationException.class);
        passwordValidator.validate("pass1pass1");
    }

    @Test
    public void whenPasswordIsValid() throws ValidationException {
        passwordValidator.validate("ram123");
    }
}
