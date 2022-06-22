package aufgabe11;

import java.time.LocalDate;

public class Person {
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;

    public Person(String firstName,String lastName, LocalDate birthDate) {
        vorname = firstName;
        nachname = lastName;
        geburtsdatum = birthDate;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", geburtsdatum=" + geburtsdatum +
                '}';
    }
}
