package com.epam.utils.validation;

/**
 * Implementations perform validation on an object of type T.
 *
 * @param <T> type of the object to be validated
 * @see NotNullValidation#validate(Object)
 * @see LengthValidation#validate(Object)
 * @see PatternValidation#validate(Object)
 * @see NoImmediateSameSequenceValidation#validate(Object)
 * @see PasswordValidator
 */
public interface ValidationRule<T> {

    /**
     * Performs validation on the {@code value}
     *
     * @param value the value to be validated
     * @throws ValidationException if the {@code value} is not validated
     *                             according to the implementation
     */
    void validate(T value) throws ValidationException;
}
