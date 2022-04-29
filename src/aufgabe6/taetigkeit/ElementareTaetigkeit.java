package aufgabe6.taetigkeit;

import aufgabe6.taetigkeit.Taetigkeit;

public class ElementareTaetigkeit implements Taetigkeit {
    private double time;
    private String beschr;

    public ElementareTaetigkeit(String beschr, double time) {
        this.beschr = beschr;
        this.time = time;
    }

    @Override
    public double getTime() {
    return time;
    }

    @Override
    public void add(Taetigkeit t) {

    }

    @Override
    public void remove(Taetigkeit t) {

    }

    @Override
    public int getAnzahl() {
        return 0;
    }
}
