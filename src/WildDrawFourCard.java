public abstract class WildDrawFourCard extends Card implements WildColorEffect, DrawEffect, SkipEffect{
    public WildDrawFourCard(int ID, int number, String color, String effect) {
        super(ID, number, color, effect);
    }
    // explanation:
    // The player chooses the color for the next play,
    // and the next player must draw four cards and loses their turn.
    // This card can only be played when the player has
    // no other cards that match the current color

    @Override
    public void wildColor(){
        // prompt the user for the new color of the topcard
    }

    @Override
    public void draw(){
        // the next player must draw 4 cards
    }

    @Override
    public void skip(){
        // The player who drew 4 cards must be skipped
    }

    public void wildDrawFour(){
        // make sure to check if the player has no other cards that match the current color
        // else throw an exception
        wildColor();
        draw();
        skip();
    }
}
