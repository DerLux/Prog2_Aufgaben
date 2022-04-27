package aufgabe4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size;
    Node<?> head, end;

    public LinkedListFrequencyTable() {
        clear();
    }


    static class Node<T> {
        Node<?> next;
        Node<?> prev;
        Element<?> data;


        public Node(Element<?> data, Node<?> n, Node<?> p) {
            this.data = data;
            this.next = n;
            this.prev = p;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        size = 0;
        head = new Node<>(null, null, null);
        end = new Node<>(null, null, head);
        head.next = end;
    }

    @Override
    public void add(T w, int f) {
        if (size == 0) {
            addAt(end, new Element<>(w, f));
            size++;
            return;
        }

        for (Node<?> temp = head.next; temp.next != null; temp = temp.next) { // überprüft, ob das Wort schon vorhanden ist
            if (temp.data.getWord().equals(w)) {
                temp.data.addFrequency(f);
                this.moveToLeft(temp);
                return;
            }
        }
        end.prev = new Node<>(new Element<>(w, f), end, end.prev);
        end.prev.prev.next = end.prev;
        size++;
        if (size >= 2) {
            moveToLeft(end.prev);
        }
    }

    private void moveToLeft(Node<?> move) {
        if (move == head.next || move.prev.data.getFrequency() > move.data.getFrequency()) {
            return; // überprüft, ob das Wort schon ganz vorne steht
        }
        for (Node<?> temp = head.next; temp.next != null; temp = temp.next) {
            if (temp.data.getFrequency() < move.data.getFrequency()) {
                move.prev.next = move.next;
                move.next.prev = move.prev;
                addAt(temp, move.data);
                return;
            }
        }
    }

    private void addAt(Node<?> at, Element<?> w) {
        if (at == head) {
            throw new RuntimeException("bist du dumm?");
        }
        if (at == end) {
            if (end.prev == head) {
                head.next = new Node<>(w, end, head);
                end.prev = head.next;
            } else
                addAt(end.prev, w);
        } else {
            at.prev = new Node<>(w, at, at.prev);
            at.prev.prev.next = at.prev;
        }
    }

    @Override
    public Element<T> get(int pos) {
        if (pos < 0 || pos > size)
            throw new RuntimeException("des goht do ned");
        int i = 0;
        for (Node<?> temp = head.next; temp.next != null; temp = temp.next) {
            if (i == pos) {
                return (Element<T>) temp.data;
            }
            i++;
        }
        throw new RuntimeException("des gits ned");
    }

    @Override
    public int get(T w) {
        for (Node<?> temp = head.next; temp.next != null; temp = temp.next) {
            if (temp.data.getWord().equals(w)) {
                return temp.data.getFrequency();
            }
        }
        return 0;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<?> current = head;

        public boolean hasNext() {
            return current.next != null;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            current = current.next;
            return (T) current.data;
        }

        public void remove() {
            throw new UnsupportedOperationException("Des gibts ned!");
        }

    }
}