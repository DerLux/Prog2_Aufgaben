package aufgabe8;

import java.util.Map;
import java.util.TreeMap;

public class ExpressionTreeApplication {

    public static void main(String[] args) {
        Var n = new Var("n");        // Variable n
        Var a = new Var("a");        // Variable a
        Var b = new Var("b");        // Variable b
        Var c = new Var("c");        // Variable c
        Constant one = new Constant(1.0);       // Konstante 1.0
        Constant two = new Constant(2.0);       // Konstante 2.0
        Constant three = new Constant(3.0);     // Konstante 2.0

        // Ausdruck e1 = a*a + b*b
        Expression e1 = new Sum(new Product(a, a), new Product(b, b));

        // Ausdruck e2 = n*(n+1)/2
        Expression e2 = new Quotient(new Product(n, new Sum(n, one)), two);

        // Ausdruck e3 = (a+b+c)/3
        Expression e3 = new Quotient(new Sum(new Sum(a, b), c), three);

        // Ausdruck e4 = a + (b + c)
        //Expression e4 = null;    // Vorsicht: Sie müssen e4 noch definieren.
        Expression e4 = new Sum(a, new Sum(b, c)); // Definition von e4

        // Belegung alle Variablen als Map:
        Map<String, Double> varBel = new TreeMap<>();
        varBel.put("a", 3.0);
        varBel.put("b", 4.0);
        varBel.put("c", 8.0);
        varBel.put("n", 10.0);

        // Evaluiere e1 und e2:
        System.out.println("\n25.0 : "+e1.eval(varBel));  // 25.0
        System.out.println("55.0 : "+e2.eval(varBel));  // 55.0
        System.out.println("5.0 : "+e3.eval(varBel));  // 5.0

        // Alle Variablen in e1:
        System.out.println("\n[a, b] : " + e1.getVars());    // [a, b]
        System.out.println("[n] : " + e2.getVars());    // [n]
        System.out.println("[a, b, c] : " + e3.getVars());    // [a, b, c]
        System.out.println("[a, b, c] : " + e4.getVars());    // [a, b, c]

        // Prüfe, ob alle Variablen in e1 belegt sind:
        System.out.println("\ntrue : " + varBel.keySet().containsAll(e1.getVars()));    // true

        // e1 und e2 ausgeben (überschriebene toString-Methode):
        System.out.println("\n"+e1);        // ((a * a) + (b * b))
        System.out.println(e2);        // ((n * (n + 1.0)) / 2.0)
        System.out.println(e3);        // (((a + b) + c) / 3.0)
    }
}
