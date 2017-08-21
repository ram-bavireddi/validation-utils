package com.epam.utils.validation;

public class NotNullValidation implements ValidationRule<String> {

    @Override
    public void validate(String value) {
        if (value == null) {
            throw new IllegalArgumentException(Messages.NOT_NULL_VALIDATION);
        }
    }
}
