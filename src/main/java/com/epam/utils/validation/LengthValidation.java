package com.epam.utils.validation;

/**
 * Performs length validation.
 */
public class LengthValidation implements ValidationRule<String> {

    /**
     * The message to provide when the validation fails
     */
    public static final String VALIDATION_FAILED_MESSAGE = "Must be between %s and %s characters in length";

    /**
     * The default minimum length to use when there is no explicit minimum length
     */
    public static final int DEFAULT_MIN_LENGTH = 5;

    /**
     * The default maximum length to use when there is no explicit maximum length
     */
    public static final int DEFAULT_MAX_LENGTH = 12;

    private final int minLength;
    private final int maxLength;

    /**
     * Constructs new {@code LengthValidation} with
     * minimum length {@link #DEFAULT_MIN_LENGTH} and maximum length {@link #DEFAULT_MAX_LENGTH}
     */
    public LengthValidation() {
        this(DEFAULT_MIN_LENGTH, DEFAULT_MAX_LENGTH);
    }

    /**
     * Constructs new {@code LengthValidation} with
     * minimum length {@code minLength} and maximum length {@code maxLength}
     *
     * @param minLength the minimum length to check
     * @param maxLength the maximum length to check
     */
    public LengthValidation(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    /**
     * Performs length validation on the {@code value}
     *
     * @param value the value to be validated
     * @throws ValidationException if length of the {@code value} is not between
     *                             {@link #minLength} and {@link #maxLength}
     */
    @Override
    public void validate(String value) throws ValidationException {
        if (!(minLength <= value.length() && value.length() <= maxLength)) {
            throw new ValidationException(createValidationFailedMessage());
        }
    }

    private String createValidationFailedMessage() {
        return String.format(VALIDATION_FAILED_MESSAGE, this.minLength, this.maxLength);
    }
}
