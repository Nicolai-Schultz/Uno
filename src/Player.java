import java.util.*;

public class Player {
    private long id;

    private final List<Card> playerHand = new ArrayList<>();

    public Player(long id) {
        this.id = id;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void drawCard(DrawPile drawPile) {
        Card cardDrawnFromPile = drawPile.drawTopCard();
        this.playerHand.add(cardDrawnFromPile);
    }

    // this is really smart. Player has a certain composition, so
    // overriding the toString means that I can output the Player exactly as it should.
    @Override
    public String toString() {
        return this.id + " + ";
    }

    public void drawCard(Card card, DrawPile drawPile) {

    }

    public void playCard(Card card, PlayPile playPile) {

    }

}
