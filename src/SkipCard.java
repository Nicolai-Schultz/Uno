public abstract class SkipCard extends Card implements Effect {
    public SkipCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void effect(GameState gameState){
        System.out.println("USED skipcard effect");
        // should increment the player turn counter from Game class.
        gameState.advanceTurn(2);
    }
}
