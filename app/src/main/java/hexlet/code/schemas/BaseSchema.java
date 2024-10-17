package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private List<Predicate<Object>> listRules = new ArrayList<>();

    public final boolean isValid(Object value) {
        return listRules.stream().allMatch(predicate -> predicate.test(value));
    }

    public final void addListRules(Predicate<Object> predicate) {
        listRules.add(predicate);
    }
}
