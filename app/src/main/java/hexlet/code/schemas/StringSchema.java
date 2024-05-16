package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;
import java.util.function.Predicate;

@Getter
@Setter
public final class StringSchema extends BaseSchema<String> {
    private Predicate<String> validators;

    public StringSchema minLength(int minLength) {
        Predicate<String> validate = string -> string.length() >= minLength;
        addCheck(
                "minLength",
                validate
        );
        return this;
    }
    public StringSchema contains(String containsString) {
        Predicate<String> validate = string -> string.contains(containsString);
        addCheck(
                "contains",
                validate
        );
        return this;
    }
    public StringSchema required() {
        Predicate<String> validate = string -> string != null && !string.isEmpty();
        addCheck(
                "requred",
                validate
        );
        return this;
    }

}
