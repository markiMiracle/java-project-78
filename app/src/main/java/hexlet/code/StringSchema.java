package hexlet.code;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Builder
@Getter
@Setter
public class StringSchema {
    private boolean isValidValue;
    private boolean requiredMethod;
    private Map<Boolean, String> containsMethodData;
    private Map<Boolean, Integer> minLengthMethodData;
    public boolean isValid(String value) {
        if (requiredMethod && !required(value)) {
            return false;
        }
        if (containsMethodData != null && !contains(value, containsMethodData.get(true))) {
            return false;
        }
        if (minLengthMethodData != null && !minLength(value, minLengthMethodData.get(true))) {
            return false;
        }
        return true;
    }
    public StringSchema required() {
        setRequiredMethod(true);
        return new StringSchemaBuilder()
                .requiredMethod(true)
                .containsMethodData(getContainsMethodData())
                .minLengthMethodData(getMinLengthMethodData())
                .build();
    }
    public StringSchema contains(String string) {
        setContainsMethodData(Map.of(true, string));
        return new StringSchemaBuilder()
                .requiredMethod(isRequiredMethod())
                .containsMethodData(Map.of(true, string))
                .minLengthMethodData(getMinLengthMethodData())
                .build();
    }
    public StringSchema minLength(int minLength) {
        setMinLengthMethodData(Map.of(true, minLength));
        return new StringSchemaBuilder()
                .requiredMethod(isRequiredMethod())
                .containsMethodData(getContainsMethodData())
                .minLengthMethodData(Map.of(true, minLength))
                .build();
    }

    private boolean required(String value) {
        return value != null && !value.isEmpty();
    }
    private boolean contains(String value, String string) {
        return value.contains(string);
    }
    private boolean minLength(String value, int minLength) {
        return value.length() >= minLength;
    }
}
