package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        addListRules(value -> value instanceof HashMap<?, ?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        addListRules(value -> value == null
                || value instanceof HashMap<?, ?> && ((HashMap<?, ?>) value).size() >= size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addListRules(checkedMap -> checkedMap == null
                || checkedMap instanceof HashMap<?, ?> && ((HashMap<?, ?>) checkedMap)
                .keySet() //get keySet of checked Map
                .stream()
                .allMatch(checkedMapKey -> schemas // check every key
                        .get(checkedMapKey) // get Schema of a key
                        .isValid(((HashMap<?, ?>) checkedMap)
                                .get(checkedMapKey)))); // check if value of a key is valid
        return this;
    }
}
