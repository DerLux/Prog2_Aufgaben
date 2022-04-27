package aufgabe4;

/**
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void add(T w) {
        add(w, 1);
    }

    @Override
    public void addAll(FrequencyTable<? extends T> fq) {
        //addiert das übergebene Array zu diesem hinzu
//        for (int i = 0; i < fq.size(); i++) {
//            this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
//        }
        int i = -1;
        for (T x: fq) {
            i++;
            //this.add(fq.get(i).getWord(), fq.get(i).getFrequency());
            Element<T> a = (Element<T>) x;
            this.add(a.getWord(), a.getFrequency());
        }
    }

    @Override
    public void collectMostFrequent(FrequencyTable<? super T> fq) {
        //fügt alle Wörter mit höchster anzahl hinzu
        fq.clear();
        int check = this.get(0).getFrequency();   //speichert höchste Zahl
        int i = 0;
        while (check == this.get(i).getFrequency()) {
            fq.add(this.get(i).getWord(), this.get(i).getFrequency());
            i++;
        }
    }

    @Override
    public void collectLeastFrequent(FrequencyTable<? super T> fq) {
        fq.clear();
        int check = this.get(size() - 1).getFrequency();   //speichert niedrigste Zahl
        int i = size() - 1;
        while (check == this.get(i).getFrequency()) {
            fq.add(this.get(i).getWord(), this.get(i).getFrequency());
            i--;
        }
    }

    /**
     * Liefert eine String-Darstellung zur&uuml;ck.
     *
     * @return String-Darstellung.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        s.append("{");
        for (int i = 0; i < this.size(); i++) { // fügt Wörter der Ausgabe hinzu
            s.append(this.get(i));
            s.append(", ");
        }
        s.append("} size = ").append(this.size());
        return s.toString();
    }
}