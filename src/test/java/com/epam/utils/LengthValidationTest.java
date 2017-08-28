package com.epam.utils;

import com.epam.utils.validation.LengthValidation;
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
public class LengthValidationTest {

    private static ValidationRule<String> validationRule;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        validationRule = new LengthValidation();
    }

    @Test
    public void passwordWithInLengthRange() {
        TestUtils.validPassword(validationRule, "bavireddi");
    }

    @Test
    public void passwordWithNoMinimumLength() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(this.expectedMessage());
        validationRule.validate("ram");
    }

    @Test
    public void passwordWithMaxLengthExceeded() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(this.expectedMessage());
        validationRule.validate("ramubavireddi");
    }

    private String expectedMessage() {
        return String.format(
                LengthValidation.VALIDATION_FAILED_MESSAGE,
                LengthValidation.DEFAULT_MIN_LENGTH,
                LengthValidation.DEFAULT_MAX_LENGTH
        );
    }
}
