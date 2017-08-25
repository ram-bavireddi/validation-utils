package com.epam.utils.validation;

/**
 * Performs null check validation.
 */
public class NotNullValidation implements ValidationRule<String> {

    /**
     * The message to provide when the validation fails
     */
    public static final String VALIDATION_FAILED_MESSAGE = "Must not be null";

    /**
     * Performs null check on the {@code value}.
     *
     * @param value the value to be validated
     * @throws ValidationException if {@code value} is null
     */
    @Override
    public void validate(String value) throws ValidationException {
        if (value == null) {
            throw new ValidationException(VALIDATION_FAILED_MESSAGE);
        }
    }
}
