public class Card{
    int ID;
    int number;
    String color;
    String effect;

    // interfaces need no-args constructor. Constructor overloading.
    Card(){};

    Card(int ID, int number, String color, String effect) {
        this.ID = ID;
        this.number = number;
        this.color = color;
        this.effect = effect;
    }

    // look into throwing certain exceptions based on the issue
    public boolean canBePlayedOn(Card other) {
        // the card can be played if it matches color, number, or is a wild card
        return this.color.equals(other.color)
            || this.number == other.number
            || this.effect.equals("WildCard")
            || this.effect.equals("WildDrawFour");
    }

    @Override
    public String toString() {
        return "[ " + color.toUpperCase() + " | " +
                (effect.equals("none") ? number : effect.toUpperCase()) + " ]";    }
}
