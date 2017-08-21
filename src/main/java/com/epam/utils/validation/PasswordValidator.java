package com.epam.utils.validation;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PasswordValidator {

    private final List<ValidationRule<String>> validationRules;

    public PasswordValidator() {
        validationRules = Arrays.asList(
                new NotNullValidation(),
                new LengthValidation(),
                new PatternValidation(),
                new NoImmediateSameSequenceValidation()
        );
    }

    public void validate(String password) {
        for (ValidationRule<String> validationRule : validationRules) {
            validationRule.validate(password);
        }
    }
}
