package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        this.required = true;
        Predicate<Object> rules = value -> value instanceof Map;
        super.addListRules(rules);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Object> rules =
                value -> value == null || value instanceof HashMap<?, ?> && ((HashMap<?, ?>) value).size() >= size;
        addListRules(rules);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addListRules(checkedMap ->
                checkedMap == null || checkedMap instanceof HashMap<?, ?> && ((HashMap<?, ?>) checkedMap)
                .keySet()
                .stream()
                .allMatch(checkedMapKey ->
                        schemas.get(checkedMapKey).isValid(((HashMap<?, ?>) checkedMap).get(checkedMapKey))));
        return this;
    }

    @Override
    public final boolean isInvalidData(Object value) {
        return !(value instanceof Map) || ((Map) value).isEmpty();
    }
}
