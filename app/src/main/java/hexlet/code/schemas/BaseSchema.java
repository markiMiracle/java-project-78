package hexlet.code.schemas;


import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;


@Setter
@Getter
public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected boolean shape = false;

    protected final void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
    }
    public final boolean isValid(T value) {
        for (var schemas: checks.entrySet()) {
            schemas.getValue().test(value);
            if (!schemas.getValue().test(value)) {
                return  false;
            }
        }
        return true;
    }
}
