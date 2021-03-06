package com.epam.utils.validation;

import java.util.regex.Pattern;

/**
 * Performs a specific validation, i.e., the value
 * must not contain any sequence of characters immediately
 * followed by the same sequence.
 *
 * @implNote This class is a decorator of {@link PatternValidation}
 */
public class NoImmediateSameSequenceValidation implements ValidationRule<String> {

    public static final String VALIDATION_FAILED_MESSAGE = "Must not contain any sequence of " +
            "characters immediately followed by the same sequence";

    private final Pattern pattern;

    public NoImmediateSameSequenceValidation() {
        pattern = Pattern.compile("(.+)\\1+$");
    }

    /**
     * Performs a specific validation on the {@code value}, i.e.,
     * the value must not contain any sequence of characters
     * immediately followed by the same sequence.
     *
     * @param value the value to be validated
     * @throws ValidationException if the {@code value} contains any sequence of
     *                             characters immediately followed by the same sequence.
     */
    @Override
    public void validate(String value) throws ValidationException {
        if (pattern.matcher(value).find()) {
            throw new ValidationException(VALIDATION_FAILED_MESSAGE);
        }
    }
}
