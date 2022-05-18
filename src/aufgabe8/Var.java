package aufgabe8;

import java.util.Set;
import java.util.Map;
import java.util.TreeSet;

public class Var implements Expression {
    private final String variable;

    public Var(String var) {
        this.variable = var;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return varBel.get(variable);
    }

    @Override
    public Set<String> getVars() {
        Set<String> var = new TreeSet<>();
        var.add(variable);
        return var;
    }

    @Override
    public String toString(){
        return variable;
    }
}
