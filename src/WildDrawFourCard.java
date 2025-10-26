import java.util.Scanner;

public abstract class WildDrawFourCard extends Card implements Effect{
    public WildDrawFourCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }
    // explanation:
    // The player chooses the color for the next play,
    // and the next player must draw four cards and loses their turn.
    // This card can only be played when the player has
    // no other cards that match the current color

    @Override
    public void effect(GameState gameState){
        System.out.println("WILDCARDdrawfour effect used");
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
        System.out.println("Used DrawTwoCard effect");
        // should add two cards to the player hand from the drawpile
        // Conceptually
        Player next = gameState.getNextPlayer();
        // draw four cards
        next.drawCard(gameState.getDrawPile());
        next.drawCard(gameState.getDrawPile());
        next.drawCard(gameState.getDrawPile());
        next.drawCard(gameState.getDrawPile());

        gameState.advanceTurn(2); // skip their turn after drawing
    }
}
