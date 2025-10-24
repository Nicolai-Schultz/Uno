public class Card {
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

    public boolean canBePlayedOn(Card other) {
        // the card being played has to equal the top card in either
        // color, number or it has to be an effect card.
        return (!(this.effect.equals("None")) && this.color.equals(other.color)) || this.color.equals(other.color) || this.number == other.number;
    }
}
