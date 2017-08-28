package com.epam.utils;

import com.epam.utils.validation.NotNullValidation;
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
public class NotNullValidationTest {

    private static ValidationRule<String> validationRule;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        validationRule = new NotNullValidation();
    }

    @Test
    public void passwordIsNotNull() throws ValidationException {
        TestUtils.validPassword(validationRule, "ram");
    }

    @Test
    public void passwordIsNull() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(NotNullValidation.VALIDATION_FAILED_MESSAGE);
        validationRule.validate(null);
    }
}
