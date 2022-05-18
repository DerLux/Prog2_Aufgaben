package aufgabe8;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Constant implements Expression {
    private final double constant;

    public Constant(double con) {
        this.constant = con;
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return this.constant;
    }

    @Override
    public Set<String> getVars() {
        return new TreeSet<>();
    }

    @Override
    public String toString(){
        return String.valueOf(constant);
    }
}
