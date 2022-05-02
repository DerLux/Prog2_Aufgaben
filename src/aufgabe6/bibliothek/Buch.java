package aufgabe6.bibliothek;

public class Buch {
    private final String titel;
    Person entleiher = new Person("niemandem");

    public Buch(String titel) {
        this.titel = titel;
    }

    public Person getEntleiher() {
        return entleiher;
    }

    public String getTitel() {
        return titel;
    }

    public boolean wirdAusgeliehen(Person p) {
        p.ausgelieheneBuecher.add(this);
        entleiher = p;
        return true;
//        if (!(p.getName().equals(entleiher.getName()))) {
//            entleiher = p;
//            return true;
//        } else      //Buch ist noch nicht verliehen
//            return false;
    }

    public void print() {
        System.out.println("Das Buch " + titel + " wird von " + entleiher.getName() + " ausgeliehen.");
    }

    public boolean wirdZurueckGegeben() {
        if (entleiher.equals(new Person("niemandem")))  // Buch war nicht verliehen
            return false;
        else {                  //Buch war verliehen
            entleiher = new Person("niemandem");
            return true;
        }

    }

}
