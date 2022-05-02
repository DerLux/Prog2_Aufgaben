package aufgabe6.bibliothek;

import java.util.LinkedList;
import java.util.List;

public class Person {
    String name;
    List<Buch> ausgelieheneBuecher = new LinkedList<>();

    public Person(String name) {
        this.name = name;
    }

    public boolean leihtAus(Buch b) {
        if(ausgelieheneBuecher.contains(b))
            return false; //Buch bereits von mir ausgeliehen
        if(!(b.getEntleiher().getName().equals("niemandem"))) {
            return false; //Buch bereits verliehen
        }
        ausgelieheneBuecher.add(b);
        b.entleiher = new Person(name);
        return true;
    }

    public void print() {
        if(ausgelieheneBuecher.isEmpty()) { //Person hat kein Buch ausgeliehen
            System.out.println(name + " hat nichts ausgeliehen");
        } else {
            StringBuilder sb = new StringBuilder();
            for (var x : ausgelieheneBuecher) {
                sb.append(x.getTitel()).append(" ");
            }
            System.out.println(name + " hat " + sb + "ausgeliehen");
        }
    }

    public boolean gibtZurueck(Buch b) {
        if(!ausgelieheneBuecher.contains(b))
            return false; //Buch nicht ausgeliehen
        ausgelieheneBuecher.remove(b);
        return b.wirdZurueckGegeben();
    }

    public String getName() {
        return name;
    }
}
