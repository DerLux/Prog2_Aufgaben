package aufgabe1;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void add(String w) {
        add(w, 1);
    }

    @Override
    public void addAll(FrequencyTable fq) {
        // Ihr Code:
        for (int i = 0; i < fq.size(); i++) { //addiert das übergebene Array zu diesem hinzu
            this.add(fq.get(i).getWord(),fq.get(i).getFrequency());
        }
    }

    @Override
    public void collectMostFrequent(FrequencyTable fq) {    //fügt alle Wörter mit höchster anzahl hinzu
        // Ihr Code:
        fq.clear();
        int check = this.get(0).getFrequency();   //speichert höchste Zahl
        int i = 0;
        while(check == this.get(i).getFrequency()) {
            fq.add(this.get(i).getWord(),this.get(i).getFrequency());
            i++;
        }
    }

    @Override
    public void collectLeastFrequent(FrequencyTable fq) {
        // Ihr Code:
        fq.clear();
        int check = this.get(size()-1).getFrequency();   //speichert niedrigste Zahl
        int i = size()-1;
        while(check == this.get(i).getFrequency()) {
            fq.add(this.get(i).getWord(),this.get(i).getFrequency());
            i--;
        }
    }

    /**
     * Liefert eine String-Darstellung zur&uuml;ck.
     * @return String-Darstellung.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        // Ihr Code:
        s.append("{");
        for (int i = 0; i < this.size(); i++){ // fügt Wörter der Ausgabe hinzu
            s.append(this.get(i));
            s.append(", ");
        }
        s.append("} size = ").append(this.size());
        return s.toString();
    }
}