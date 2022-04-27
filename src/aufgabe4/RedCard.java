
package aufgabe4;

public class RedCard extends Card {

    public RedCard() {
        this.Suit = SuitsRed[(int)(Math.random()*2)];
        this.Rank = Ranks[(int)(Math.random()*8)];
    }

    public RedCard(String Suit, String Rank) {
        this.Suit = Suit;
        this.Rank = Rank;
    }
}