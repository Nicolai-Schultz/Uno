import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = DrawPile.makeDeck();
        DrawPile.printDeck(deck);

        Collections.shuffle(deck);
        DrawPile.printDeck(deck);
    }
}
