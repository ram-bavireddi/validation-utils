package com.epam.utils.validation;

public interface ValidationRule<T> {

    void validate(T value);
}
