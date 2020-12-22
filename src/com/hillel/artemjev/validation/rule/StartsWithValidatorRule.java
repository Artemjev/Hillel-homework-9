package com.hillel.artemjev.validation.rule;


public class StartsWithValidatorRule implements ValidatorRule<String> {
    private String start;

    public StartsWithValidatorRule(String start) {
        this.start = start;
    }

    @Override
    public boolean validate(String value) {
        return value.startsWith(start);
    }

    @Override
    public String errorMessage() {
        return "Doesn't start with \"" + start + "\"";
    }
}
