public abstract class ReverseCard extends Card implements Effect {
    public ReverseCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void effect(GameState gameState){
        System.out.println("ReverseCard effect used");
        // should reverse the order of player turn. This should call a method from the Game class.
        // probably something like subtracting one from the playerturn counter.
        gameState.reversePlayersList();
        // it advances the turn on the reversed list
        gameState.advanceTurn(1);
    }
}
