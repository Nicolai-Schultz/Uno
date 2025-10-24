public abstract class ReverseCard extends Card implements ReverseEffect {
    public ReverseCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void reverse(){
        // should reverse the order of player turn. This should call a method from the Game class.
        // probably something like subtracting one from the playerturn counter.
    }
}
