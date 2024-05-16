package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public void required() {
        Predicate<Map<String, String>> validate = Objects::nonNull;
        addCheck(
                "required",
                validate
        );
    }

    public void sizeof(int size) {

        Predicate<Map<String, String>> validate = value -> value.size() == size;
        addCheck(
                "sizeof",
                validate
        );
    }
    public void shape(Map<String, BaseSchema<String>> schemas) {
        setShape(true);
        for (var schema : schemas.entrySet()) {
            Predicate<String> validate = value -> true;
            for (var sch : schema.getValue().getChecks().entrySet()) {
                validate = validate.and(sch.getValue());
            }
            addCheck(schema.getKey(), validate);
        }
    }
}
