public class Card{
    int ID;
    int number;
    String color;
    String effect;

    Card(int ID, int number, String color, String effect) {
        this.ID = ID;
        this.number = number;
        this.color = color;
        this.effect = effect;
    }

    // look into throwing certain exceptions based on the issue
    public boolean canBePlayedOn(Card other) {
        // the card can be played if it matches color, number, or is a wild card
        return
            this.effect.equals("DrawTwoCard") && this.color.equals(other.color)
            || this.effect.equals("SkipCard") && this.color.equals(other.color)
            || this.effect.equals("ReverseCard") && this.color.equals(other.color)
            || this.color.equals(other.color)
            || this.number == other.number
            || this.effect.equals("WildCard")
            || this.effect.equals("WildDrawFour")
            || this.effect.equals("none") && !other.effect.equals("none");
    }

    @Override
    public String toString() {
        return "[ " + color.toUpperCase() + " | " +
                (effect.equals("none") ? number : effect.toUpperCase()) + " ]";    }

}
