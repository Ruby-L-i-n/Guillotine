

/**
 * A class that represents the gameplay setup
 * @author Ruby Lin
 */
public class Gameplay{
  /** a list that represents the deck of the card*/
  private LinkedList<Card> deck = new LinkedList<Card>();

  /** 
   * a constructor to create a new game
   */
  public Gameplay(){
    //all 40 cards are added to the deck 
    deck.addToFront(new Card("Marie Antoinette", "Royal", 5));
    deck.addToFront(new Card("Regent", "Royal", 4));
    deck.addToFront(new Card("Duke", "Royal", 3));
    deck.addToFront(new Card("Baron", "Royal", 3));
    deck.addToFront(new Card("Countess", "Royal", 2));
    deck.addToFront(new Card("Lord", "Royal", 2));
    deck.addToFront(new Card("Lady", "Royal", 2));
    deck.addToFront(new Card("Cardinal", "Church", 5));
    deck.addToFront(new Card("King Louis XVI", "Royal", 5));
    deck.addToFront(new Card("Count", "Royal", 2));
    deck.addToFront(new Card("Archbishop", "Church", 4));
    deck.addToFront(new Card("Nun", "Church", 3));
    deck.addToFront(new Card("Bishop", "Church", 2));
    deck.addToFront(new Card("Priest", "Church", 1));
    deck.addToFront(new Card("Priest", "Church", 1));
    deck.addToFront(new Card("Heretic", "Church", 0));//special cards with a changing point will be set as 0
    deck.addToFront(new Card("Governor", "Civic", 4));
    deck.addToFront(new Card("Mayor", "Civic", 3));
    deck.addToFront(new Card("Councilman", "Civic", 3));
    deck.addToFront(new Card("Judge", "Civic", 2));
    deck.addToFront(new Card("Judge", "Civic", 2));
    deck.addToFront(new Card("Tax Collector", "Civic", 0));
    deck.addToFront(new Card("Sheriff", "Civic", 1));
    deck.addToFront(new Card("Sheriff", "Civic", 1));
    deck.addToFront(new Card("Palace Guard", "Military", 0));
    deck.addToFront(new Card("Palace Guard", "Military", 0));
    deck.addToFront(new Card("Palace Guard", "Military", 0));
    deck.addToFront(new Card("Palace Guard", "Military", 0));
    deck.addToFront(new Card("Palace Guard", "Military", 0));
    deck.addToFront(new Card("General", "Military", 4));
    deck.addToFront(new Card("Colonel", "Military", 3));
    deck.addToFront(new Card("Captain", "Military", 2));
    deck.addToFront(new Card("Lieutenant", "Military", 1));
    deck.addToFront(new Card("Lieutenant", "Military", 1));
    deck.addToFront(new Card("Tragic Figure", "Commoner", 0));
    deck.addToFront(new Card("Heroic Figure", "Commoner", -3));
    deck.addToFront(new Card("Student", "Commoner", -1));
    deck.addToFront(new Card("Student", "Commoner", -1));
    deck.addToFront(new Card("Student", "Commoner", -1));
    deck.addToFront(new Card("Student", "Commoner", -1));
    for (int i = 0; i < 5 + (int)Math.random() * 10; i++)//shuffle the cards a random amount of times to make sure it is random
      deck.shuffle();
  }
  
  /** 
   * a method that gets the deck in the game
   * @return the list of cards in the deck
   */
  public LinkedList<Card> getDeck(){
    return this.deck; 
  }
  
  /**
   * a method that counts the amount of cards in the list that is in a certain group
   * @param deck the list of cards used to find
   * @param group the group that we want to find
   * @return number of cards in the deck that is in the group
   */
  public int containsGroup(LinkedList<Card> deck, String group){
    LLNode<Card> nodeptr = deck.getFirstNode();//a node pointer
    int i = 0; 
    while (nodeptr!= null){
      if(nodeptr.getElement().getGroup().equals(group))
        i++; 
      nodeptr = nodeptr.getNext(); //points to the next node
    }
    return i; 
  }
  
  /**
   * a method that sets the deck of the card
   * @param deck the new deck 
   */
  public void setDeck(LinkedList<Card> deck){
    this.deck = deck;
  }
  
  

}