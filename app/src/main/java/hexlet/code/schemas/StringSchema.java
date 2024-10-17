package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        this.required = true;
        Predicate<Object> rules = value -> value instanceof String && !value.equals("");
        super.addListRules(rules);
        return this;
    }

    public StringSchema minLength(int minLength) {
        Predicate<Object> rules = value -> value.toString().length() >= minLength;
        super.addListRules(rules);
        return this;
    }

    public StringSchema contains(String substring) {
        addListRules(value -> value == null || value instanceof String && ((String) value).contains(substring));
        return this;
    }

    @Override
    boolean isInvalidData(Object value) {
        return !(value instanceof String) || ((String) value).isEmpty();
    }
}
