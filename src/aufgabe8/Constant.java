package aufgabe8;

import java.util.Map;
import java.util.Set;

public class Constant implements Expression{
    private final double constant;
    public Constant(double con) {
        this.constant = con;
    }

    public double getConstant(){
        return constant;
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
