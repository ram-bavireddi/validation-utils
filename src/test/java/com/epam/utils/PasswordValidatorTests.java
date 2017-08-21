package com.epam.utils;

import com.epam.utils.validation.Messages;
import com.epam.utils.validation.PasswordValidator;
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
    public void whenNullPassword() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Messages.NOT_NULL_VALIDATION);
        passwordValidator.validate(null);
    }

    @Test
    public void whenPasswordLengthNotBetween5And12() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Messages.LENGTH_VALIDATION);
        passwordValidator.validate("ram");
    }

    @Test
    public void whenPasswordDoesNotMatchRegEx() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Messages.REGEX_PATTERN_VALIDATION);
        passwordValidator.validate("password");
    }

    @Test
    public void whenPasswordHasImmediateSequenceOfChars() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(Messages.NO_IMMEDIATE_SAME_SEQUENCE_VALIDATION);
        passwordValidator.validate("pass1pass1");
    }

    @Test
    public void whenPasswordIsValid() {
        passwordValidator.validate("ram123");
    }
}
