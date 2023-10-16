# Guillotine - Project for Intro to Java Course
## Background:

Guillotine is a game for two to five players, but it works best with two players. The game consists of a large set of cards. Each card represents a person that a player wishes to either collect or avoid. Each card has a name/occupation (general, priest, king, tax collector, Marie Antoinette) a group (church, military, royalty, civic, commoner), and a point value. Some cards also provide special bonuses. The cards are placed in a line on the table and players take turns taking the first card from the line until all the cards are gone. Before a player takes a card, they can do a special action which rearranges the cards in the line. The goal is to end up with the most points at the end of the game. Since a player can only take the first card of the line, the game strategy is determining when to use special actions to rearrange the line in order to take more points than the other player.

**I made the following changes to the game:**

* There will be a single "round" in the game where a set number of cards are placed in the line. 

* The default will be 20 cards, and the game ends as soon as these cards are all taken.

* Each player will have exactly the same special actions available to them, and each special action can be used only in the game.

* A player can use as many special actions as they want on their turn as long as no special action is used more than once in the game.


* Some of the cards and actions will be simplified or removed from our game.

## Rules:

At the start of the game, 20 "person" cards are placed in a line. The cards are selected and ordered randomly from the following cards: 

![](/Image/cards1.png)
![](/Image/cards2.png)

A player can then choose to do one or more of the following actions, but each action other than selecting a person card can only be taken once per game. The player's turn ends when they either select the front person from the line or they choose the "Skip Turn" action.

Here are the possible actions a player can take prior to taking the card at the front of the line.

* Move the lead card back exactly 4 places.
* Move the lead card back exactly 3 places.
* Move the lead card back exactly 2 places.
* Move the lead card back exactly 1 place.
* Move the lead card to the end of the line.
* Move the last card of the line to the front.
* Reverse the entire line of cards.
* Reverse the first 5 cards of the line.
* Skip the turn (end the player's turn but don't take a card).
* Take the first card from the line (ends the player's turn).

Only the last action can be used multiple times. The rest can only be used once in the game.

The game ends when the last person is taken from the line, and the player with the most points wins the game.

## Display

The game is a JavaFX application with only JavaFX gadgets

![](/Image/gameplay.png)