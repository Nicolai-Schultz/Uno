# UNO – Java Console Game
Made by Nicolai Schultz, Jonatan D. Muhle-Zimino and Nikolai Dyrby Knudsen

## Core difference in implementation from specifications in the assignment description
we chose not to implement an interface per. special card. we did not understand how it was effective to do so, since we had to implement a static 
switch case / collection of if-conditions in the GameState class in order to call the effect method. we chose to create one interface called effect. 
This implied that every card has an effect. In the GameState class, it simply checks if the card being played implements the effect interface; if it does
it calls the effect method. 

By doing it this way, it is dynamic. If one were to add a new special card to the game of UNO the process would be:
Create class "NewSpecialCard". Let it inherit attributes from Card and let it implement an effect. The effect method should be overriden to fit the 
new cards specifications. No need to update the GameState class' method: PlayGame, since it dynamically detects if an effect is present in the card object.

By the way, we are aware that there is duplicated code in the WildCard and WildDrawFour. Maybe this is why multiple interfaces should be created?

## Questions:
- How OOP-minded is the solution?
- How else could the interface issue be solved?
- Are the classes too large?


## 🕹️ How to Play
1. The player's hand is displayed.
2. Choose to either play a card (press C) or draw a card (press D).
3. Be aware of whose turn it is by noting the line "Hello x here are your cards".
4. Once zero cards are reached the player has won. 