package aufgabe4;

import java.util.Objects;

public abstract class Card {
    String Suit;
    String Rank;

    public final static String HEARTS = "Herz";
    public final static String PIQUE = "Pique";
    public final static String KARO = "Karo";
    public final static String KREUZ = "Kreuz";

    public final static String SEVEN = "7";
    public final static String EIGHT = "8";
    public final static String NINE = "9";
    public final static String TEN = "10";
    public final static String JACK = "Bube";
    public final static String QUEEN = "Dame";
    public final static String KING = "König";
    public final static String ACE = "Ass";

    public static String[] Suits = {HEARTS, PIQUE, KARO, KREUZ};
    public static String[] SuitsRed = {HEARTS, KARO};
    public static String[] SuitsBlack = {PIQUE, KREUZ};
    public static String[] Ranks = {SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING, ACE};


    public int get(String w) {
        return 0;
    }
    @Override
    public String toString() {
        return Suit + " " + Rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return Suit.equals(card.Suit) && Rank.equals(card.Rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Suit, Rank);
    }

    public Boolean equals() {
        return false;
    }
}