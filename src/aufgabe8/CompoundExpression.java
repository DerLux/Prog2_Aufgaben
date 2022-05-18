package aufgabe8;

import java.util.Map;
import java.util.Set;

public class CompoundExpression implements Expression {
    private Expression left;
    private Expression right;

    public CompoundExpression(Expression e1, Expression e2) {
        this.left = e1;
        this.right = e2;
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
