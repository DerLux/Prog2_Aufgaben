package aufgabe8;

import java.util.Collection;
import java.util.Map;

public interface Expression {

    boolean eval(Map<String, Double> varBel);

    Collection<?> getVars();

    @Override
    String toString();
}
