package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Predicate;

@Getter
@Setter
public class StringSchema extends BaseSchema {

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
    public void required() {
        Predicate<String> validate = string -> string != null && !string.isEmpty();
        addCheck(
                "requred",
                validate
        );
    }

}
