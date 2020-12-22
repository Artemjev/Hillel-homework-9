package com.hillel.artemjev.validation.rule;

import java.util.regex.Pattern;


public class RegExpValidatorRule implements ValidatorRule<String> {
    private Pattern pattern;

    public RegExpValidatorRule(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean validate(String value) {
        return pattern.matcher(value).matches();
    }

    @Override
    public String errorMessage() {
        return "Does not match regular expression \"" + pattern.pattern() + '\"';
    }
}
