import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // creates the deck and shuffles it, via the constructor
        var drawPile = new DrawPile();
        var gameState = new GameState();
        gameState.gameStart(drawPile);
    }
}
