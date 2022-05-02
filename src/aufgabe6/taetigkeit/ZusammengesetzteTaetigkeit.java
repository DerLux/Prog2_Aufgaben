package aufgabe6.taetigkeit;

import java.util.List;

public abstract class ZusammengesetzteTaetigkeit implements Taetigkeit {
    protected List<Taetigkeit> meineTaetigkeit;

    public double getTime() {
        return 0;
    }

    public void add(Taetigkeit k) {
        if (meineTaetigkeit.contains(k)) {
            return; //Bereits in Liste
        }
        meineTaetigkeit.add(k);
    }

    public void remove(Taetigkeit k) {

    }

    public int getAnzahl() {
        int count = 0;
        for (var x : meineTaetigkeit) {
            count += x.getAnzahl();
        }
        return count;
    }
}
