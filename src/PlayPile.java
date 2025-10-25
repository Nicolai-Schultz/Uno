import java.util.ArrayList;
import java.util.List;

public class PlayPile {
    private final List<Card> playPile = new ArrayList<>();

    public void playPileDrawsAndAdds(DrawPile drawPile){
        Card topCard = drawPile.drawTopCard();
        // insert into playPile
        add(topCard);
    }

    public List<Card> getPlayPile() {
        return playPile;
    }

    public Card getTopCard() {
        return playPile.getLast();
    }

    public void add(Card card){
        playPile.add(card);
    }
}
