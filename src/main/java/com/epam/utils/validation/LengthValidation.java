package com.epam.utils.validation;

public class LengthValidation implements ValidationRule<String> {

    @Override
    public void validate(String value) {
        if (!(5 <= value.length() && value.length() <= 12)) {
            throw new IllegalArgumentException(Messages.LENGTH_VALIDATION);
        }
    }
}
