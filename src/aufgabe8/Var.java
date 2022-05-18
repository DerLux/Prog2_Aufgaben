package aufgabe8;

import java.util.Set;
import java.util.Map;

public class Var implements Expression {
    private final String variable;

    public Var(String var) {
        this.variable = var;
    }

    public String getVariable() {
        return variable;
    }

    @Override
    public boolean eval(Map<String, Double> varBel) {
        return false;
    }

    @Override
    public Set<String> getVars() {
        return null;
    }
}
