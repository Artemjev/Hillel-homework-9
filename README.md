***TODO:***
-----------------------------
Develop a value validator according to the attached diagram.

Interface **ObjectValidator\<T>** is used to validate values.
Its implementation **RulesBasedObjectValidator\<T>** performs validation according to the list of rules (**ValidatorRule** interface).
![ValidatorDiagram](https://user-images.githubusercontent.com/18448571/163901920-a6871a3b-6397-49f0-bb9e-4502335ff40e.png)
Each rule checks the value according to its own criteria and contains 2 methods:

***validate*** - returns the result of field validation;

***errorMessage*** - returns the error text to be used (if applicable) to describe the problem.

If at least one of the validation rules returned *false* when checked, then **RulesBasedObjectValidator**
throws a **ValidationException** with the appropriate error text.


***Задание:***
-----------------------------
Написать валидатор значений согласно приложенной диаграмме. 

Интерфейс **ObjectValidator\<T>** служит для валидации значений. 
Его реализация **RulesBasedObjectValidator\<T>** проводит валидацию согласно списка правил (интерфейс **ValidatorRule**). 
Каждое правило проверяет значение по своим критериям и содержит 2 метода:

***validate*** - возвращает результат проверки поля;

***errorMessage*** - возвращает текст ошибки, который необходимо использовать (если это необходимо) для описания проблемы.

Если хоть одно из правил валидации вернуло *false* при проверке, то **RulesBasedObjectValidator** 
выбрасывает исключение **ValidationException** с соответствующим текстом ошибки.

*Примеры использования завершенного валидатора:*
```
List<ValidatorRule> rules = new ArrayList<>();
rules.add(new RegExpValidatorRule(Pattern.compile("\\+\\d{12}")));
rules.add(new StartsWithValidatorRule("+38"));
ObjectValidator<String> validator = new RulesBasedObjectValidator<>(rules);

try{
   validator.validate(phone);
   //далее работа с номером
}catch (ValidationException e){
    System.out.println("Неверный номер "+e.getMessage());
 ```
 
 *Второй пример:*
```
List<ValidatorRule> rules = new ArrayList<>();
rules.add(new MaxNumberValidatorRule(10));
rules.add(new MinNumberValidatorRule(0));

ObjectValidator<Number> validator = new RulesBasedObjectValidator<>(rules);

try{
   validator.validate(num);
   //далее работа с числом
}catch (ValidationException e){
    System.out.println("Недопустимое значение "+e.getMessage());
}
```
