package aufgabe6.taetigkeit;

import java.util.List;

public abstract class ZusammengesetzteTaetigkeit implements Taetigkeit {
    protected List<Taetigkeit> meineTaetigkeit;

    public double getTime() {
        return 0;
    }

    public void add(Taetigkeit k) {

    }

    public void remove(Taetigkeit k) {

    }

    public int getAnzahl() {
        return 0;
    }
}
