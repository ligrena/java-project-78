package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        this.required = true;
        Predicate<Object> rules = value -> value instanceof Integer;
        super.addListRules(rules);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> rules = value -> value instanceof Integer && (int) value > 0;
        addListRules(rules);
        return this;
    }

    public NumberSchema range(int start, int end) {
        addListRules(value -> value == null || value instanceof Integer && (int) value >= start && (int) value <= end);
        return this;
    }

    @Override
    boolean isInvalidData(Object value) {
        return !(value instanceof Integer);
    }
}
