package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        Predicate<Map> required = map -> map != null;
        listRules.put("required", required);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map> sizeof = map -> map.size() == size;
        listRules.put("sizeof", sizeof);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Predicate<Map> shape = map -> {
            for (Map.Entry<String, BaseSchema<String>> schema : schemas.entrySet()) {
                for (Map.Entry<String, Object> data : ((Map<String, Object>) map).entrySet()) {
                    if (schema.getKey().equals(data.getKey())) {
                        if (!schema.getValue().isValid(data.getValue())) {
                            return false;
                        }
                    }
                }
            }
            return true;
        };
        listRules.put("shape", shape);
        return this;
    }
}
