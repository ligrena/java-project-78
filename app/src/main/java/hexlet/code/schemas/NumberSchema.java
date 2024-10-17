package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addListRules(value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addListRules(value -> value == null || value instanceof Integer && (int) value > 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        addListRules(value -> value == null || value instanceof Integer && (int) value >= start && (int) value <= end);
        return this;
    }
}
