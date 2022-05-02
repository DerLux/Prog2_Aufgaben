package aufgabe6.taetigkeit;

public class ElementareTaetigkeit implements Taetigkeit
{
    private final double time;
    private String beschr;

    public ElementareTaetigkeit(String beschr, double time)
    {
        this.beschr = beschr;
        this.time = time;
    }

    @Override
    public double getTime()
    {
        return this.time;
    }

    @Override
    public void add(Taetigkeit t)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Taetigkeit t)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAnzahl()
    {
        return 1;
    }

}