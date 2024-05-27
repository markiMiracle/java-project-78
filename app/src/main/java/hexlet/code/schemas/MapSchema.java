package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public void required() {
        Predicate<Map<?, ?>> validate = Objects::nonNull;
        addCheck(
                "required",
                validate
        );
    }

    public MapSchema sizeof(int size) {

        Predicate<Map<?, ?>> validate = value -> value.size() == size;
        addCheck(
                "sizeof",
                validate
        );
        return this;
    }
    public <T> void shape(Map<String, BaseSchema<T>> schemas) {
        addCheck(
                "shape",
                 map -> {
                     return schemas.entrySet().stream().allMatch(e -> {
                         var v = map.get(e.getKey());
                         var schema = e.getValue();
                         return schema.isValid((T) v);
                     });
                 });
    }

}
