package com.epam.utils.validation;

import java.util.regex.Pattern;

public class NoImmediateSameSequenceValidation implements ValidationRule<String> {

    private static final Pattern PATTERN = Pattern.compile("(.+)\\1+");

    @Override
    public void validate(String value) {
        if (PATTERN.matcher(value).find()) {
            throw new IllegalArgumentException(Messages.NO_IMMEDIATE_SAME_SEQUENCE_VALIDATION);
        }
    }
}
