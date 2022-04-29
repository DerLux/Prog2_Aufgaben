package aufgabe6.taetigkeit;

public interface Taetigkeit {
    public double getTime();
    public void add(Taetigkeit t);
    public void remove(Taetigkeit t);
    public int getAnzahl();
}
