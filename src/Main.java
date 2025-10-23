import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Card> cards = DrawPile.makeDeck();
        DrawPile.printDeck(cards);
    }
}
