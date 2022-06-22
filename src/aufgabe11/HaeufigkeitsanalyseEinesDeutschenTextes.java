package aufgabe11;
/* Wortweises Einlesen eines deutschen Textes von einer Datei.
 * Ermittlung der Haefigkeiten der Woerter und Ausgabe der
 * 100 haeufigsten Woerter.
 *
 * Oliver Bittel; 10.03.2019
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;
import java.util.stream.Stream;

//für Ausgabe als Liste
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class HaeufigkeitsanalyseEinesDeutschenTextes {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Map<String, Integer> haeufigkeit = ermittleHaufigekeiten("Kafka_Der_Prozess.txt");
        printTop100(haeufigkeit);
    }

    public static Map<String, Integer> ermittleHaufigekeiten(String fileName) throws FileNotFoundException, IOException {

        LineNumberReader in = new LineNumberReader(new FileReader(fileName));
        String line;

        Map<String, Integer> haeufigkeit = new TreeMap<>();    // enthaelt zu jedem Wort seine Haefigkeit

        while ((line = in.readLine()) != null) {
            String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
            for (String w : wf) {
                if (w.length() == 0 || w.length() == 1)
                    continue;
                System.out.println(w);
                // Ihr Code:
                if(haeufigkeit.containsKey(w)) {
                    haeufigkeit.replace(w, haeufigkeit.get(w) + 1);
                } else {
                    haeufigkeit.put(w, 1);
                }
                //if (haeufigkeit.replace(w, haeufigkeit.get(w) + 1) == null)
                //    haeufigkeit.put(w, 1);
            }
            // ...
        }

        return haeufigkeit;
    }

    public static void printTop100(Map<String, Integer> h) {
        // Ihr Code:
        //als Liste

        long start = System.nanoTime(); // aktuelle Zeit in nsec

        System.out.println("\n\n\n");
        List<Entry<String, Integer>> list = new ArrayList<>(h.entrySet());
        list.sort(Entry.comparingByValue());
        //list.forEach(System.out::println);

        int index = list.size();
        for(int i = 0; i < 100; i++) {
            System.out.println(list.get(--index));
        }

        long end = System.nanoTime();
        double elapsedTime = (double)(end-start)/1.0e06; // Zeit in msec
        System.out.println(elapsedTime);

        System.out.println("\n\n\n");
        //als Stream

        start = System.nanoTime(); // aktuelle Zeit in nsec

        //Stream<Map.Entry<String, Integer>> sorted =
                h.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(100).forEach(System.out::println);
        //sorted.limit(100).forEach(System.out::println);

        end = System.nanoTime();
        elapsedTime = (double)(end-start)/1.0e06; // Zeit in msec
        System.out.println(elapsedTime);

        //Map.Entry.comparingByValue().reversed()
//        h.entrySet().stream()
//                .map(value -> -value).sorted().map(i -> -i)
//                .sorted(Map.Entry.comparingByValue().reversed());
//                .forEach(System.out::println);

        //h.stream()
        //        .map
        //        .sorted(Comparator.comparing(h::containsValue))
        //        .forEach(System.out::println);
        // ...
    }

}
