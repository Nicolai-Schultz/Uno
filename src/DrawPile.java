import java.util.*;

public class DrawPile {
    private final List<Card> cards = new ArrayList<>();

    public DrawPile() {
        String[] color = {"Red", "Green", "Blue", "Yellow"};
        int ID = 0;
        // Creating all cards which number is zero; there should only be one of each
        for(String currentColor: color){
            List<Card> cards = this.getCards();
            cards.add(new NumberCard(ID, 0, currentColor, "none"){});
        }
        // Creating all numbered cards; there should be two of each
        for (String currentColor : color) {
            for (int value = 1; value <= 9; value++) {
                List<Card> cards = this.getCards();
                //
                cards.add(new NumberCard(ID, value, currentColor, "none"){});
                ID++;
                cards.add(new NumberCard(ID, value, currentColor, "none"){});
                ID++;
            }
        }

        // Creating all specials
        // There should be two of each skip, reverse and drawTwo per color.
        for (String currentColor : color) {
            for (int j = 0; j < 2; j++) {
                List<Card> cards = this.getCards();
                // skip
                cards.add(new SkipCard(ID, 0, currentColor, "SkipCard") {
                });
                ID++;
                // reverse
                cards.add(new ReverseCard(ID, 0, currentColor, "ReverseCard") {
                });
                ID++;
                // drawTwo
                cards.add(new DrawTwoCard(ID, 0, currentColor, "DrawTwoCard") {
                });
                ID++;
            }
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
        // shuffle cards
        Collections.shuffle(this.getCards());
    }

    public List<Card> getCards() {
        return cards;
    }

    // cannot return a single card as it has to remove that card from the pile as well
    // has to interact directly with playerHand
    // method cannot be in Player class, since drawCard has to directly access the deck
    public Card drawTopCard() {
        List<Card> cards = this.getCards();
        Card topCard = cards.getFirst();
        // assume cards are shuffled and take from the top, while removing it from the drawPile
        cards.removeFirst();
        return topCard;
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
        DrawPile.printDeck(this.cards);
    }
}
