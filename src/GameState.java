import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameState {
    private static final int FIRST_DRAW_CONSTANT = 7;
    private final List<Player> players = new ArrayList<>();

    private final DrawPile drawPile = new DrawPile();
    public DrawPile getDrawPile() {
        return drawPile;
    }

    public void gameStart(DrawPile drawPile) {
        System.out.println("Welcome to UNO!" + "\n" + "Type amount of Players:");
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = scanner.nextInt();
        System.out.println("You entered: " + numberOfPlayers);
        // store a list of players


        // for each number of players, generate a Player
        // give each player a random hand
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i));

            // draw 7 cards per player. Uno rules
            for(int j = 0; j < FIRST_DRAW_CONSTANT; j++){
                players.get(i).drawCard(drawPile);
            }
        }

        // test display of generated players
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(players.get(i).toString());
            System.out.println(players.get(i).getPlayerHand().toString());
        }


    }
}
