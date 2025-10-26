import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GameState {
    private static final int FIRST_DRAW_CONSTANT = 7;
    private final List<Player> players = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final PlayPile playPile = new PlayPile();
    private final DrawPile drawPile = new DrawPile();
    private int currentTurn;

    public Scanner getScanner() {
        return scanner;
    }

    public void setTopCard(String color) {
        // this creates an issue. Given that a player plays a wildcard, the number does not become irrelevant; meaning that a player
        // is not forced to play the chosen color.
        // this is fixed by giving the card an unmatchable number.

        // the id can never be between 0 and 107 (or 108), picking 108 just to be certain
        java.util.Random random = new java.util.Random();
        int id;
        do {
            id = random.nextInt(10000);
        } while (id <= 108);
        int number = 999;

        String effect = "None";
        Card topCard = new Card(id, number, color, effect);
        playPile.add(topCard);
    }

    public void reversePlayersList() {
        Collections.reverse(this.players);
        int n = players.size();
        if (n > 0) {
            this.currentTurn = n - 1 - this.currentTurn;
        }
    }

    public Player getNextPlayer() {
        return players.get(normalizeIndex(getCurrentTurn() + 1));
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
                // if the played card is incompatible, it should rerun loop.
                if (!actionPlayCard(cardId)) continue;
                // Use effect of card. If a numbercard is played it should simply increment turnofplay
                // should check if player has 0 cards
                actionRemoveCardFromHand(cardId);
                if (gameWonCheck()) break;
                // useEffect should look at the top card.
                // in order to do this properly, actionPlayCard should restart the loop if card is incompat.
                useEffect(this);
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

    private boolean gameWonCheck() {
        // a player wins when they have no cards left
        // the engine should continously check each player hand to see if any are == 0.
        // could be improved by simply checking the state of current_player_hand
        if(players.get(currentTurn).getPlayerHand().isEmpty()){
            System.out.println(players.get(currentTurn) + " wins!");
            return true;
        }
        return false;
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

    private boolean actionPlayCard(int cardId){
        if (players.get(getCurrentTurn()).playCard(cardId, getPlayPile())){
            System.out.println("You played: " + getPlayPile().getTopCard());
            return true;
        }
        return false;
    }

    private void actionRemoveCardFromHand(int cardId) {
        // issue here. Removes from the next player's hand.
        players.get(getCurrentTurn()).removeCardFromHand(cardId);
    }

    private void actionDrawCard(){
        players.get(getCurrentTurn()).drawCard(getDrawPile());
        // maybe display drawn card?
    }

    private void useEffect(GameState gameState) {
        Card playedCard = playPile.getTopCard();
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
