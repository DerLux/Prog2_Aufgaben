package aufgabe8;

import java.util.Collection;
import java.util.Map;

public class CompoundExpression implements Expression{
    private Expression left;
    private Expression right;

    public CompoundExpression(Expression e1, Expression e2){
        this.left = e1;
        this.right = e2;
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
