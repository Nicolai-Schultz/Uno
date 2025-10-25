import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameState {
    private static final int FIRST_DRAW_CONSTANT = 7;
    private final List<Player> players = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private PlayPile playPile = new PlayPile();
    private final DrawPile drawPile = new DrawPile();
    private int currentTurn;

    public int getNumberOfPlayers() {
        return players.size();
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public PlayPile getPlayPile() {
        return playPile;
    }

    public DrawPile getDrawPile() {
        return drawPile;
    }

    public void gameStart(DrawPile drawPile) {
        System.out.println("Welcome to UNO!" + "\n" + "Type amount of Players:");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("You entered: " + numberOfPlayers);
        // store a list of players


        // for each number of players, generate a Player
        // give each player a random hand
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i));

            // draw 7 cards per player. Uno rules
            for(int j = 0; j < FIRST_DRAW_CONSTANT; j++){
                players.get(i).drawCard(drawPile);
            }
        }
    }

    public void playGame() {
        // simulate one round
        // The first player in the player list starts
        // this player gets shown their hand, and chooses which they want to play
        // before playing the game should check if the card is playable
        // if the card has an effect it should affect the next player

        // game should only draw at the start of each game ONCE
        // draw top card, add to playPile and display to user
        gameDraws();

        do {
            int currentTurn = getCurrentTurn();

            System.out.println("Hello " + players.get(currentTurn).toString() + " here are your cards: ");

            // display hand
            displayHand();

            // display top card
            displayTopCard();

            // choose action
            String actionChoice = getActionChoice();

            // do action
            if(actionChoice.equals("c")){
                int cardId = getCardFromId();
                actionPlayCard(cardId);
                // Use effect of card. If a numbercard is played it should simply increment turnofplay
                useEffect(cardId, this);
            } else if (actionChoice.equals("d")) {
                actionDrawCard();
                incrementTurn(1);
            } else {
                System.out.println("Wrong button pressed. Try again");
            }

            // Idea for a break. A metaGameState could check the length of each player hand
            // if 0 the game stops, and the player wins. This is compute-heavy though..
        } while (true);
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = normalizeIndex(currentTurn);
    }

    private int normalizeIndex(int index) {
        int n = players.size();
        if (n == 0) return 0;
        int m = index % n;
        return (m < 0) ? m + n : m;
    }

    public void advanceTurn(int step) {
        this.currentTurn = normalizeIndex(this.currentTurn + step);
    }

    private void incrementTurn(int step){
        advanceTurn(step);
    }

    private int getCardFromId() {
        System.out.println("Choose card [type id]");
        return scanner.nextInt();
    }

    private void actionPlayCard(int cardId){
        players.get(getCurrentTurn()).playCard(cardId, getPlayPile());
        System.out.println("You played: " + getPlayPile().getTopCard());
    }

    private void actionDrawCard(){
        players.get(getCurrentTurn()).drawCard(getDrawPile());
        displayHand();
    }

    private void useEffect(int cardId, GameState gameState) {
        Card playedCard = players.get(getCurrentTurn()).getCardFromHand(cardId);
        if (playedCard instanceof Effect effectCard) {
            effectCard.effect(gameState);
        }
    }

    private String getActionChoice() {
        System.out.println("Play card [c] or draw card [press d]");
        return scanner.next();
    }

    private void displayHand() {
        List<Card> hand = players.get(getCurrentTurn()).getPlayerHand();
        for (int i = 0; i < hand.size(); i++) {
            System.out.println("[" + i + "] " + hand.get(i));
        }
    }

    private void gameDraws() {
        // Play pile draws top card from draw pile
        getPlayPile().playPileDrawsAndAdds(getDrawPile());
    }

    private void displayTopCard() {
        System.out.println("Top card: " + getPlayPile().getTopCard());
    }
    
}
