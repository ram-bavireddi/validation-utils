package com.epam.utils.validation;

import java.util.regex.Pattern;

/**
 * Performs pattern validation.
 */
public class PatternValidation implements ValidationRule<String> {

    /**
     * The message to provide when the validation fails
     */
    public static final String VALIDATION_FAILED_MESSAGE = "Must consist of a combination of lowercase letters " +
            "and numerical digits only, with at least one of each";

    /**
     * The default pattern to use when there is no explicit pattern
     */
    public static final String DEFAULT_PATTERN = "(?=.*[a-z])(?=.*[0-9])[a-z0-9]+";

    private final Pattern pattern;

    /**
     * Constructs new {@code PatternValidation} with
     * the pattern {@link #DEFAULT_PATTERN}
     */
    public PatternValidation() {
        this(DEFAULT_PATTERN);
    }

    /**
     * Constructs new {@code PatternValidation} with
     * the pattern {@code patternToValidate}
     *
     * @param patternToValidate the pattern to validate
     */
    public PatternValidation(String patternToValidate) {
        this.pattern = Pattern.compile(patternToValidate);
    }

    /**
     * Performs pattern validation on the {@code value}.
     *
     * @param value the value to be validated
     * @throws ValidationException if the {@code value} does not comply the {@link #pattern}
     */
    @Override
    public void validate(String value) throws ValidationException {
        if (!pattern.matcher(value).find()) {
            throw new ValidationException(createValidationFailedMessage());
        }
    }

    private String createValidationFailedMessage() {
        if (DEFAULT_PATTERN.equals(pattern.pattern())) {
            return VALIDATION_FAILED_MESSAGE;
        }
        return "Must comply with the pattern " + pattern.pattern();
    }
}
