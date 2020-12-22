package com.hillel.artemjev.validation;

import com.hillel.artemjev.validation.exception.ValidationException;
import com.hillel.artemjev.validation.rule.*;
import com.hillel.artemjev.validation.validator.ObjectValidator;
import com.hillel.artemjev.validation.validator.RulesBasedObjectValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        List<ValidatorRule<String>> phoneRules = new ArrayList<>();
        phoneRules.add(new RegExpValidatorRule(Pattern.compile("\\+\\d{12}")));
        phoneRules.add(new StartsWithValidatorRule("+38"));
        ObjectValidator<String> validatorPhoneStr = new RulesBasedObjectValidator<String>(phoneRules);

        String[] phones = new String[]{
                "+380501111111",
                "+380502222222",
                "+380503333333",
                "+3805044444",
                "+3805055555555",
                "380501234567",
                "+480501234567",
                "+380501234567"
        };

        for (String phone : phones) {
            try {
                validatorPhoneStr.validate(phone);
                //работа с номером
            } catch (ValidationException e) {
                System.out.printf("Invalid format of number %s. %s.\n", phone, e.getMessage());
            }
        }

        System.out.println("\n*********************************************************\n");

        List<ValidatorRule<Number>> numberRules = new ArrayList<>();
        numberRules.add(new MaxNumberValidatorRule(10));
        numberRules.add(new MinNumberValidatorRule(0));

        ObjectValidator<Number> validatorNumber = new RulesBasedObjectValidator<Number>(numberRules);

        Number[] numbers = new Number[]{1, 2, 3.7, 77.7, 37, -5, 55};

        for (Number num : numbers) {
            try {
                validatorNumber.validate(num);
                // работа с числом
            } catch (ValidationException e) {
                System.out.println("Invalid value of number " + num + "! " + e.getMessage());
            }
        }
    }
}
