package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        Predicate<Integer> required = i -> i != null;
        listRules.put("required", required);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = integer -> {
            if (integer == null) {
                return true;
            } else {
                return integer > 0;
            }
        };
        listRules.put("positive", positive);
        return this;
    }

    public NumberSchema range(int start, int end) {
        Predicate<Integer> range = number -> number >= start && number <= end;
        listRules.put("range", range);
        return this;
    }
}
