package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate> listRules = new LinkedHashMap<>();

    public final boolean isValid(Object value) {
        for (String key : listRules.keySet()) {
            if (!listRules.get(key).test(value)) {
                return false;
            }
        }
        return true;
    }
}
