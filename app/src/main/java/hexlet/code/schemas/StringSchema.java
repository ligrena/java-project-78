package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        Predicate<String> isNotEmpty = string -> string != null && !(string.trim().isEmpty());
        listRules.put("isNotEmpty", isNotEmpty);
        return this;
    }

    public StringSchema minLength(int min) {
        Predicate<String> minLength = string -> string.length() >= min;
        listRules.put("minLength", minLength);
        return this;
    }

    public StringSchema contains(String substring) {
        Predicate<String> contains = string -> string.contains(substring);
        listRules.put("contains", contains);
        return this;
    }
}
