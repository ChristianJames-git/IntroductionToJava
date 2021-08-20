public class CardDeck {
        public String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        public String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        public String[] deck = new String[52];

        public String getIdentificationString() {
            return "Program 2b, Christian James";
        }
        public CardDeck() {
            int k = 0;
            int i = 0;
            int j = 0;
            for (i = 0; i < ranks.length; i++, k += 3) {
                for (j = 0; j < suits.length; j++) {
                    deck[i + j + k] = ranks[i] + " of " + suits[j];
                }
            }
        }
        public String getCard(int index) {
            return deck[index];
        }
        public String getFirst() {
            return deck[0];
        }
        public String getLast() {
            return deck[deck.length - 1];
        }
        public String randomCard() {
            return deck[4];
        }
        public String royalFlush() {
            return deck[34] + ", " + deck[38] + ", " + deck[42] + ", " + deck[46] + ", " + deck[50];
        }
}