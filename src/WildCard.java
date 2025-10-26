import java.util.Scanner;

public abstract class WildCard extends Card implements Effect {
    public WildCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void effect(GameState gameState){
        System.out.println("WILDCARD effect used");
        // should prompt the user for color, and change the value of the topcard to that color.
        // "Red", "Green", "Blue", "Yellow"
        System.out.println("Choose a new color! RED [0], GREEN [1], BLUE [2], YELLOW [3]");
        Scanner scanner = gameState.getScanner();
        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                gameState.setTopCard("Red");
                break;
            case 1:
                gameState.setTopCard("Green");
                break;
            case 2:
                gameState.setTopCard("Blue");
                break;
            case 3:
                gameState.setTopCard("Yellow");
                break;
        }
        gameState.advanceTurn(1);
    }
}
