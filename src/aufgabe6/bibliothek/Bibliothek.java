// O. Bittel
// 9.3.2018

package aufgabe6.bibliothek;

public class Bibliothek {

    public static void main(String[] args) {
        Buch b1 = new Buch("Tod auf dem Nil");
        Buch b2 = new Buch("Alibi");
        Buch b3 = new Buch("Mord im Orientexpress");
        Person p1 = new Person("Peter");
        Person p2 = new Person("Maria");

        System.out.println("\n1. true: " + p1.leihtAus(b1));                      // true
        System.out.println("2. true: " + b2.wirdAusgeliehen(p1) + "\n");          // true

        p1.print();

        System.out.println("\n3. false: " + p2.leihtAus(b1));                   // false
        System.out.println("4. true: " + p1.gibtZurueck(b1));                   // true
        System.out.println("5. true: " + p2.leihtAus(b1));                      // true
        System.out.println("6. true: " + b3.wirdAusgeliehen(p2) + "\n");        // true

        p1.print();
        p2.print();
        b1.print();
        b2.print();
        b3.print();

        System.out.println("\n7. false :" + p1.gibtZurueck(b1));           // false
        System.out.println("8. true: " + b2.wirdZurueckGegeben());         // true
        System.out.println("9. true: " + p2.gibtZurueck(b1));              // true
        System.out.println("0. true: " + b3.wirdZurueckGegeben() + "\n");  // true

        p1.print();
        p2.print();
        b1.print();
        b2.print();
        b3.print();
    }

}
