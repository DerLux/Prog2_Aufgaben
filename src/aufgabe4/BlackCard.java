package aufgabe4;

public class BlackCard extends Card {

    public BlackCard() {
        this.Suit = SuitsBlack[(int)(Math.random()*2)];
        this.Rank = Ranks[(int)(Math.random()*8)];
    }

    public BlackCard(String Suit, String Rank) {
        this.Suit = Suit;
        this.Rank = Rank;
    }
}