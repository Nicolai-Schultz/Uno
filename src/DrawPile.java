import java.util.*;

public class DrawPile {


    public static List<Card> makeDeck() {
        List<Card> cards = new ArrayList<>();
        String[] color = {"Red", "Green", "Blue", "Yellow"};
        int ID = 0;
        for (int i = 0; i < 4; i++) {
            String currentColor = color[i];
            for (int value = 0; value <= 9; value++) {
                cards.add(new Card(ID, value, currentColor, "None"));
                ID++;
                cards.add(new Card(ID, value, currentColor, "None"));
                ID++;
            }
        }
        return cards;
    }

    public static void printDeck(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(
                cards.get(i).color +
                cards.get(i).number
            );
        }
    }
}
