package aufgabe4;

/**
 * Klasse fÃ¼r WÃ¶rter mit ihren HÃ¤ufigkeiten.
 * @author oliverbittel
 * @since 22.3.2019
 */
public class Element<T> {
    final private T word;
    private int freqency;

    /**
     * Konstruktor.
     * @param word Wort
     * @param f H&auml;ufgkeit
     */
    public Element(T word, int f) {
        this.word = word;
        this.freqency = f;
    }

    /**
     * Liefert Wort zur&uuml;ck.
     * @return Wort
     */
    public T getWord() {
        return word;
    }

    /**
     * Liefert H&auml;ufgkeit zur&uuml;ck.
     * @return H&auml;ufgkeit
     */
    public int getFrequency() {
        return freqency;
    }

    /**
     * Addiert zur H&auml;ufgkeit f dazu.
     * @param f H&auml;ufgkeits&auml;nderung.
     */
    public void addFrequency(int f) {
        freqency += f;
    }

    /**
     * Liefert eine String-Darstellung zur&uuml;ck.
     * @return String-Darstellung.
     */
    @Override
    public String toString() {
        return word + ":" + freqency;
    }
}