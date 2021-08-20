public class PlayingCard {
    public String rank;
    public String suit;

    public String getIdentificationString() {
        return "Program 2a, Christian James";
    }
    public PlayingCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public String goodCard(String rank) {
        if (rank.equals("10") || rank.equals("Jack") || rank.equals("Queen") || rank.equals("King") || rank.equals("Ace"))
            return "That's a good card!";
        else
            return "This card is alright.";
    }
    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }
    public String toString() {
        return rank + " of " + suit;jav
    }
    public static void main(String[] args) {
        PlayingCard(Ace, Spades);
        System.out.println(goodCard(getRank()));
        System.out.println(getRank());
        System.out.println(getSuit());
        System.out.println(toString());
    }
}