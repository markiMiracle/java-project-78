package hexlet.code;

import lombok.Getter;

@Getter
public class Validator {
    public StringSchema string() {
        return new StringSchema.StringSchemaBuilder().build();
    }
}
