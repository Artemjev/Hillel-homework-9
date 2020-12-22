package com.hillel.artemjev.validation.rule;


public interface ValidatorRule<T> {

    boolean validate(T value);

    String errorMessage();
}
