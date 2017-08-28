package com.epam.utils;

import com.epam.utils.validation.ValidationException;
import com.epam.utils.validation.ValidationRule;

import static org.junit.Assert.assertNull;

public class TestUtils {

    private TestUtils() {
        throw new AssertionError("No com.epam.utils.TestUtils instances for you");
    }

    public static void validPassword(ValidationRule<String> validationRule, String password) {
        ValidationException validationException = null;
        try {
            validationRule.validate(password);
        } catch (ValidationException ex) {
            validationException = ex;
        }
        assertNull("No ValidationException", validationException);
    }
}
