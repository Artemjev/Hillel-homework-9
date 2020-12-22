package com.hillel.artemjev.validation.rule;


public class MaxNumberValidatorRule implements ValidatorRule<Number> {
    private Number maxValue;

    public MaxNumberValidatorRule(Number maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public boolean validate(Number value) {
        return value.doubleValue() <= maxValue.doubleValue();
    }

    @Override
    public String errorMessage() {
        return "Exceeds maximum value " + maxValue;
    }
}
