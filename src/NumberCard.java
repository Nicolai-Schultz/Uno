public abstract class NumberCard extends Card implements Effect {
    public NumberCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void effect(GameState gameState) {
        System.out.println("Used NumberCard effect");
        gameState.advanceTurn(1);
    }
}
