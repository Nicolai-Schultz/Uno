public abstract class WildCard extends Card implements WildColorEffect {
    public WildCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void wildColor(){
        // should prompt the user for color, and change the value of the topcard to that color.
    }
}
