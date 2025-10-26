import java.util.*;

public class Player {
    private final long id;

    private final List<Card> playerHand = new ArrayList<>();

    public Player(long id) {
        this.id = id;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void removeCardFromHand(int cardId){
        playerHand.remove(cardId);
    }

    public Card getCardFromHand(int cardId){
        return getPlayerHand().get(cardId);
    }

    public void drawCard(DrawPile drawPile) {
        Card cardDrawnFromPile = drawPile.drawTopCard();
        this.playerHand.add(cardDrawnFromPile);
    }

    // this is really smart. Player has a certain composition, so
    // overriding the toString means that I can output the Player exactly as it should.
    @Override
    public String toString() {
        return this.id + " ";
    }

    public boolean playCard(int cardId, PlayPile playPile) {
        // get card from hand and put in play pile
        Card cardToPlay = getCardFromHand(cardId);
        Card topCard = playPile.getTopCard();
        // check if card is compatible with other card from playPile
        if(cardToPlay.canBePlayedOn(topCard)) {
            playPile.add(cardToPlay);
            // check if a card has an effect, and use that effect
            return true;
        } else {
            System.out.println("Cards are not compatible. Play another or choose to draw a card.");
            return false;
        }
    }
}
