public abstract class NumberCard extends Card implements Effect {
    public NumberCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void effect(GameState gameState) {
        gameState.advanceTurn(1);
    }
}
