public abstract class DrawTwoCard extends Card implements DrawEffect {
    public DrawTwoCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }

    @Override
    public void draw() {
        // should add two cards to the player hand from the drawpile
    }
}
