package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected boolean required;
    private List<Predicate> listRules = new ArrayList<>();

    public final void addListRules(Predicate rules) {
        listRules.add(rules);
    }

    public final boolean isValid(Object value) {
        if (!required && isInvalidData(value)) {
            return true;
        }
        for (Predicate<Object> rules : listRules) {
            if (!rules.test(value)) {
                return false;
            }
        }
        return true;
    }

    abstract boolean isInvalidData(Object value);
}
