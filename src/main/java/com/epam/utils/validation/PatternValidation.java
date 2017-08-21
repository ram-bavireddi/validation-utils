package com.epam.utils.validation;

import java.util.regex.Pattern;

public class PatternValidation implements ValidationRule<String> {

    private static final Pattern PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[0-9])[a-z0-9]+$");

    @Override
    public void validate(String value) {
        if (!PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(Messages.REGEX_PATTERN_VALIDATION);
        }
    }
}
