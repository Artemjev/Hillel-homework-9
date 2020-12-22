package com.hillel.artemjev.validation.validator;

import com.hillel.artemjev.validation.exception.ValidationException;


public interface ObjectValidator<T> {
    void validate(T o) throws ValidationException;
}
