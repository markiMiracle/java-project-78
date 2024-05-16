package hexlet.code.schemas;


import java.util.Objects;
import java.util.function.Predicate;


public class NumberSchema extends BaseSchema {
    public NumberSchema range(int min, int max) {
        Predicate<Integer> validate = number -> number >= min && number <= max;
        addCheck(
                "range",
                validate
        );
        return this;
    }

    public void required() {
        Predicate<Integer> validate = Objects::nonNull;
        addCheck(
                "requred",
                validate
        );
    }

    public NumberSchema positive() {
        Predicate<Integer> validate = number -> number == null || number > 0;
        addCheck(
                "positive",
                validate
        );
        return this;
    }
}
