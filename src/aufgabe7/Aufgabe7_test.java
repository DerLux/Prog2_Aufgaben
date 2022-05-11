package aufgabe7;

import aufgabe4.BlackCard;
import aufgabe4.Card;
import aufgabe4.RedCard;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Random;

public class Aufgabe7_test<T> {

    public static final int M = 200;

    static Integer[] list = new Integer[M];
    static Integer[] list2 = new Integer[M];
    static Integer[] list3 = new Integer[M];
    static String[] stringList = new String[75000];

    public static void main(String[] args) throws IOException {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < M; i++) {
            list[i] = (int) (Math.random() * M);
            s.append(list[i]).append(", ");
        }

        list2 = list.clone();
        list3 = list.clone();

        //Quicksort();
        //QuickortMedian();
        //Arraysort();
        //Stringsort();
        Cardsort();
        System.out.println("");
    }

    private static void Cardsort() {
        int len = 200000;
        Card[] cardTab1 = new Card[len];

        Random rand = new Random();

        for (int i = 0; i < len; i++) {
            if (rand.nextInt() % 2 == 0) {
                RedCard c = new RedCard();
                cardTab1[i] = c;
            } else {
                BlackCard c = new BlackCard();
                cardTab1[i] = c;
            }
        }

        long start = System.nanoTime();
        //QuickSort.quickSort(cardTab1,0,len-1);
        //DreiMedianStrategie.quickSortMedian(cardTab1,0,len-1);
        Arrays.sort(cardTab1);
        long end = System.nanoTime();
        double elapsedTime = (double) (end - start) / 1.0e06; // Zeit in msec
        System.out.println("\nBenötigte Zeit für Cardsort in msec: " + elapsedTime);

        start = System.nanoTime();
        //QuickSort.quickSort(cardTab1,0,len-1);
        //DreiMedianStrategie.quickSortMedian(cardTab1,0,len-1);
        //Arrays.sort(cardTab1);
        end = System.nanoTime();
        elapsedTime = (double) (end - start) / 1.0e06; // Zeit in msec
        System.out.println("\nBenötigte Zeit für Cardsort sortet in msec: " + elapsedTime);
    }

    private static void Stringsort() throws FileNotFoundException,IOException{
        LineNumberReader in;
        in = new LineNumberReader(new FileReader("Kafka_Der_Prozess.txt"));
        String line;

        // Text einlesen und Häfigkeiten aller Wörter bestimmen:
        int j = 0;
        while ((line = in.readLine()) != null) {
            String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");

            for (String w: wf) {
                if (w.length() == 0 || w.length() == 1)
                    continue;
                //System.out.println(w);

                stringList[j] = w;
                j++;
            }
        }

        //System.out.println(stringList[0]);// Ausgabe des 1. Wertes im unsortierten Array
        int f = 0;
        for(int i = 75000-1; i>=0; i--) {
            if (stringList[i - 1] != null) {

                f = i;
                break;
            }
        }
        long start = System.nanoTime(); // aktuelle Zeit in nsec
        QuickSort.quickSort(stringList,0,f-1);
        //DreiMedianStrategie.quickSortMedian(stringList,0,f-1);
        //Arrays.sort(stringList);
        //System.out.println(stringList[0]); // Ausgabe des 1. Wertes im sortierten Array
        long end = System.nanoTime();
        double elapsedTime = (double)(end-start)/1.0e06; // Zeit in msec
        System.out.println("\nBenötigte Zeit für Stringsort in msec: " + elapsedTime);
    }

    private static void Quicksort() {
        long start = System.nanoTime();
        QuickSort.quickSort(list,0,199);
        long end = System.nanoTime();
        double elapsedTime = (double) (end - start) / 1.0e06; // Zeit in msec
        System.out.println("\nBenötigte Zeit für Quicksort in msec: " + elapsedTime);
    }

    private static void QuickortMedian(){
        long start = System.nanoTime();
        QuickSort.quickSort(list2,0,M-1);
        long end = System.nanoTime();
        double elapsedTime = (double) (end - start) / 1.0e06; // Zeit in msec
        System.out.println("\nBenötigte Zeit für QuicksortMedian in msec: " + elapsedTime);
    }

    private static void Arraysort(){
        long start = System.nanoTime();
        Arrays.sort(list3);
        long end = System.nanoTime();
        double elapsedTime = (double) (end - start) / 1.0e06; // Zeit in msec
        System.out.println("\nBenötigte Zeit für Arraysort in msec: " + elapsedTime);
    }
}
