package aufgabe8;

import java.util.Map;
import java.util.Set;

public abstract class CompoundExpression implements Expression {
    final Expression e1;
    final Expression e2;

    public CompoundExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

//    @Override
//    public abstract double eval(Map<String, Double> varBel);

    @Override
    public Set<String> getVars() {
        Set<String> set = this.e1.getVars();
        set.addAll(this.e2.getVars());
        return set;
    }
}
