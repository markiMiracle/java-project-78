package hexlet.code.schemas;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;


@Setter
@Getter
public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected Map<String, Predicate<T>> nestedChecks = new LinkedHashMap<>();
    protected boolean shape = false;

    protected void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
    }
    protected void addNestedCheck(String name, Predicate<T> schemas) {
        nestedChecks.put(name, schemas);
    }
    public final boolean isValid(T value) {
        for (var schemas: checks.entrySet()) {
            schemas.getValue().test(value);
            if (!schemas.getValue().test(value)) {
                return  false;
            }
        }
        if (shape) {
            for (var schemas: nestedChecks.entrySet()) {
                var element = ((HashMap<?, ?>) value).get(schemas.getKey());
                if (!schemas.getValue().test((T) element)) {
                    return false;
                }
            }
        }
        return true;
    }
}
