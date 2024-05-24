package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public void required() {
        Predicate<Map<String, String>> validate = Objects::nonNull;
        addCheck(
                "required",
                validate
        );
    }

    public MapSchema sizeof(int size) {

        Predicate<Map<String, String>> validate = value -> value.size() == size;
        addCheck(
                "sizeof",
                validate
        );
        return this;
    }
    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        addCheck(
                "shape",
                 map -> {
                     return schemas.entrySet().stream().allMatch(e -> {
                         var v = ((Map<?, ?>) map).get(e.getKey());
                         var schema = e.getValue();
                         return schema.isValid((T) v);
                     });
                 });
        return this;
    }

}
