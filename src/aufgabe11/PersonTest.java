package aufgabe11;

import java.net.Socket;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class PersonTest {
    public static void main(String[] args) {
        List<Person> personen1 = new ArrayList<>();
        personen1.add(new Person("Jona", "Böcker", LocalDate.of(2000,2,9)));
        personen1.add(new Person("Tobias", "Stöhr", LocalDate.of(1997,3,2)));
        personen1.add(new Person("Wiebke", "Prinz", LocalDate.of(2001,9,27)));
        personen1.add(new Person("Lukas", "Butscher", LocalDate.of(2010,1,1)));
        personen1.add(new Person("AJona", "Böcker", LocalDate.of(2000,2,9)));
        personen1.add(new Person("ATobias", "Stöhr", LocalDate.of(1997,3,2)));
        personen1.add(new Person("AWiebke", "Prinz", LocalDate.of(2001,9,27)));
        personen1.add(new Person("ALukas", "Butscher", LocalDate.of(2010,1,1)));

        System.out.println("a)");
        //Predicate<LocalDate> is18 = (date-> date.isAfter(LocalDate.now().minusYears(18)));
        Predicate<Person> is18 = (person-> person.getGeburtsdatum().isAfter(LocalDate.now().minusYears(18)));

        for (var person:personen1){
            if(is18.test(person)) {
                System.out.println("es gibt eine Person unter 18");
                break;
            }
        }

//        for (var person:personen1) {
//            if(person.getGeburtsdatum().plusYears(18).isAfter(LocalDate.now())){
//                System.out.println("es gibt eine Person unter 18");
//                break;
//            }
//        }

        System.out.println("b)");
        Comparator<Person> cmp = (x,y)->x.getGeburtsdatum().compareTo(y.getGeburtsdatum());
        Collections.sort(personen1,cmp);
        System.out.println(personen1.toString());

        System.out.println("c)");
        Collections.sort(personen1,cmp.reversed());
        System.out.println(personen1.toString());

        System.out.println("d)");
        personen1.stream()
                .filter(is18.negate())
                .sorted(cmp)
                .map(Person::getGeburtsdatum)
                .forEach(System.out::println);

        System.out.println("e)");
        personen1.stream()
                .filter(person -> person.getVorname().startsWith("A"))
                .sorted(cmp)
                .limit(3)
                .forEach(System.out::println);





    }
}
