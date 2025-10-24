import java.util.Scanner;

public class GameState {

    public void GameStart() {
        System.out.println("Welcome to UNO!" + "\n" + "Type amount of Players:");
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = scanner.nextInt();
        System.out.println("You entered: " + numberOfPlayers);
    }
}
