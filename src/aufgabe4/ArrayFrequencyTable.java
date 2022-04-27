package aufgabe4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size;
    private Element<T>[] fqTable;

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public final void clear() {
        size = 0;
        fqTable = new Element[100];
    }

    public void add(T w, int f) {
        if (this.size() >= this.fqTable.length) {
            this.fqTable = Arrays.copyOf(fqTable, size * 2); //verdoppelt die länge das Arrays, falls es voll ist
        }
//        int index;
//        for (int i = 0; i < this.size; i++) { // überprüft, ob das Wort schon vorhanden ist
//            if (this.fqTable[i].getWord().equals(w)) {
//                index = i;
//                this.fqTable[index].addFrequency(f);
//                this.movetoleft(index);
//                return;
//            }
//        }
        int index = -1;
        for (var x : fqTable) {
            index++;
            if (x != null && x.getWord().equals(w)) {
                x.addFrequency(f);
                this.movetoleft(index);
                return;
            }
        }
        // fügt ein neues Wort mit seiner Anzahl hinzu
        this.fqTable[size++] = new Element<>(w, f);
        this.movetoleft(size - 1);
    }

    private void movetoleft(int pos) {
        if (pos == 0)
            return;
        Element<T> w = fqTable[pos];
        int i = pos - 1;
        while (i >= 0 && w.getFrequency() > fqTable[i].getFrequency()) {
            fqTable[i + 1] = fqTable[i];
            i--;
        }
        fqTable[i + 1] = w;
    }


    @Override
    public Element<T> get(int pos) {
        return fqTable[pos];
    }

    @Override
    public int get(T w) {
//        for (int i = 0; i < this.size; i++) { // fügt Wörter der Ausgabe hinzu
//            if (this.fqTable[i].getWord().equals(w))
//                return this.fqTable[i].getFrequency();
//        }
        for (var x : fqTable) {
            if (x != null && x.getWord().equals(w))
                return x.getFrequency();
        }
        return 0;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        int current = -1;

        public boolean hasNext() {
            return current <= size && fqTable[current + 1] != null;
        }

        public T next() {
            if (hasNext()) {
                return (T) fqTable[++current];
            } else
                throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Des gibts ned!");
        }
    }
}