package aufgabe8;

import java.util.Map;
import java.util.Set;

public interface Expression {

    boolean eval(Map<String, Double> varBel);

    Set<String> getVars();

    @Override
    String toString();
}
