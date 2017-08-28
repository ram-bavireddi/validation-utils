package com.epam.utils;

import com.epam.utils.validation.NoImmediateSameSequenceValidation;
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
public class NoImmediateSameSequenceValidationTest {

    private static ValidationRule<String> validationRule;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void init() {
        validationRule = new NoImmediateSameSequenceValidation();
    }

    @Test
    public void passwordHasNoImmediateSequenceOfSameChars() {
        TestUtils.validPassword(validationRule, "ram");
    }

    @Test
    public void passwordHasImmediateSequenceOfSameChars() throws ValidationException {
        thrown.expect(ValidationException.class);
        thrown.expectMessage(NoImmediateSameSequenceValidation.VALIDATION_FAILED_MESSAGE);
        validationRule.validate("pass1pass1");
    }
}
