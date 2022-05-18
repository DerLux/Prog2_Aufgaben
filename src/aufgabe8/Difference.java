package aufgabe8;

import java.util.Map;

public class Difference extends CompoundExpression {
    public Difference(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public double eval(Map<String, Double> varBel) {
        return this.e1.eval(varBel) - this.e2.eval(varBel);
    }

    @Override
    public String toString(){
        return "(" +  this.e1.toString() + " - "+ this.e2.toString() +")";
    }
}
