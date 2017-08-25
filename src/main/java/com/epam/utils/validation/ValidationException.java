package com.epam.utils.validation;

/**
 * Thrown to indicate there is an validation error
 */
public class ValidationException extends Exception {

    /**
     * Constructs a {@code ValidationException} with no
     * detail message.
     */
    public ValidationException() {
        super();
    }

    /**
     * Constructs a {@code ValidationException} with the
     * specified detail message.
     *
     * @param message the detail message.
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a {@code ValidationException} with the
     * specified detail message and cause.
     * <p>
     * Note that the detail message associated with {@code cause} is
     * <i>not</i> automatically incorporated in this exception's detail
     * message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link Throwable#getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link Throwable#getCause()} method).  (A <tt>null</tt> value
     *                is permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
