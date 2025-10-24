public class Card {
    int ID;
    int number;
    String color;
    // interfaces need no-args constructor. Constructor overloading.
    Card(){};

    Card(int ID, int number, String color) {
        this.ID = ID;
        this.number = number;
        this.color = color;
    }

    public boolean canBePlayedOn(Card other) {
        return this.color.equals(other.color) || this.number == other.number;
    }
}
