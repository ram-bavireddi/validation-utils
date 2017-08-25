package com.epam.utils.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Performs validation on the password against the
 * rules {@link PasswordValidator#validationRules}
 */
public class PasswordValidator {

    /**
     * The validation rules to apply on a password
     */
    private List<ValidationRule<String>> validationRules;

    /**
     * Constructs a {@link PasswordValidator} with the validation rules
     * {@link NotNullValidation}
     * {@link LengthValidation}
     * {@link PatternValidation}
     * {@link NoImmediateSameSequenceValidation}
     */
    public PasswordValidator() {
        this(Arrays.asList(
                new NotNullValidation(),
                new LengthValidation(),
                new PatternValidation(),
                new NoImmediateSameSequenceValidation()
        ));
    }

    /**
     * Constructs a {@link PasswordValidator} with the
     * validation rules {@code validationRules}
     *
     * @param validationRules the list of validation rules to apply
     */
    public PasswordValidator(List<ValidationRule<String>> validationRules) {
        this.validationRules = new ArrayList<>(validationRules);
    }

    /**
     * Performs validation on the {@code password}
     *
     * @param password the password to validate
     * @throws ValidationException if the {@code password} is not valid against the
     *                             rules {@link #validationRules}
     */
    public void validate(String password) throws ValidationException {
        for (ValidationRule<String> validationRule : validationRules) {
            validationRule.validate(password);
        }
    }
}
