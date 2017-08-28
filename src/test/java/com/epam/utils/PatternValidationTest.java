package com.epam.utils;

import com.epam.utils.validation.PatternValidation;
import com.epam.utils.validation.ValidationException;
import com.epam.utils.validation.ValidationRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PatternValidationTest {

    private static ValidationRule<String> validationRule;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        validationRule = new PatternValidation();
    }

    @Test
    public void passwordMatchesRegEx() {
        TestUtils.validPassword(validationRule, "ram123");
    }

    @Test
    public void passwordDoesNotMatchRegEx() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(PatternValidation.VALIDATION_FAILED_MESSAGE);
        validationRule.validate("password");
    }
}
