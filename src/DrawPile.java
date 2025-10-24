import java.util.*;

public class DrawPile {
    private final List<Card> cards = new ArrayList<>();


    public List<Card> getCards() {
        return cards;
    }

    public List<Card> makeDeck() {
        String[] color = {"Red", "Green", "Blue", "Yellow"};
        int ID = 0;
        // Creating all cards which number is zero; there should only be one of each
        for(String currentColor: color){
            List<Card> cards = this.getCards();
            cards.add(new Card(ID, 0, currentColor, "none"));
        }
        // Creating all numbered cards; there should be two of each
        for (String currentColor : color) {
            for (int value = 1; value <= 9; value++) {
                List<Card> cards = this.getCards();
                //
                cards.add(new Card(ID, value, currentColor, "none"));
                ID++;
                cards.add(new Card(ID, value, currentColor, "none"));
                ID++;
            }
        }

        // Creating all specials
        // There should be two of each skip, reverse and drawTwo per color.
        for(int i = 0; i < (color.length*2); i++){
            List<Card> cards = this.getCards();
            // skip
            cards.add(new SkipCard(ID, 0, "SkipCard", "SkipCard") {
            });

            // reverse
            cards.add(new ReverseCard(ID, 0, "ReverseCard", "ReverseCard") {
            });

            // drawTwo
            cards.add(new DrawTwoCard(ID, 0, "DrawTwoCard", "DrawTwoCard") {
            });
        }

        // creating all wildcards
        // for each color there should be generated a WildCard AND a WildDrawFour
        for (String currentColor : color) {
                List<Card> cards = this.getCards();
                // wildcard
                cards.add(new WildCard(ID, 0, "WildCard", "WildCard") {
                });
                ID++;

                // wilddrawfour
                cards.add(new WildDrawFourCard(ID, 0, "WildDrawFour", "none") {
                });
                ID++;
        }

        return this.cards;
    }



    public static void printDeck(List<Card> cards) {
        for (Card card : cards) {
            System.out.println(
                    card.color +
                    card.number
            );
        }
    }

    public void makeDeckAndPrint() {
        DrawPile.printDeck(this.makeDeck());
    }

    // this shuffles:
    // Collections.shuffle(deck);
    //        DrawPile.printDeck(deck);
}
