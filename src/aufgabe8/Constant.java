package aufgabe8;

import java.util.Collection;
import java.util.Map;

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
    public Collection<?> getVars() {
        return null;
    }
}
