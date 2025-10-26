public abstract class DrawTwoCard extends Card implements Effect {
    public DrawTwoCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void effect(GameState gameState) {
        System.out.println("Used DrawTwoCard effect");
        // should add two cards to the player hand from the drawpile
        // Conceptually
        Player next = gameState.getNextPlayer();
        // draw two cards
        next.drawCard(gameState.getDrawPile());
        next.drawCard(gameState.getDrawPile());

        gameState.advanceTurn(2); // skip their turn after drawing
    }
}
