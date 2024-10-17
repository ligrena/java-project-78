package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        addListRules(sentence -> sentence instanceof String && ((String) sentence).length() > 0);
        return this;
    }

    public StringSchema minLength(int minLength) {
        addListRules(sentence -> sentence == null || sentence instanceof String && ((String) sentence).length() >= minLength);
        return this;
    }

    public StringSchema contains(String value) {
        addListRules(sentence -> sentence == null || sentence instanceof String && ((String) sentence).contains(value));
        return this;
    }
}
