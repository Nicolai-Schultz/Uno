public abstract class SkipCard extends Card implements SkipEffect {
    public SkipCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void skip(){
        // should increment the player turn counter from Game class.
    }
}
