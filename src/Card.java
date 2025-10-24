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
}
