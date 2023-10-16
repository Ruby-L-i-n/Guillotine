/** 
 * a class that represents all the cards
 * @author Ruby Lin
 */
public class Card{
  /** the point of the card*/
  private int points; 
  /** the name of the card*/
  private String name; 
  /** the group of the card*/
  private String group;
  
  /**
   * a Constructor that creates a card
   * 
   * @param name a String that represents the name 
   * @param group a String that represents the group the card belongs to
   * @param points the number of points of the card
   */
  public Card(String name, String group, int points) {
    this.name = name; 
    this.group = group; 
    this.points = points;
  }
  
  /**
   * a method that gets the name of the card
   * @return the name of the card
   */
  public String getName(){
    return name; 
  }
  
  /**
   * a method that gets the group of the card
   * @return the group of the card
   */
  public String getGroup(){
    return group; 
  }
  
  /**
   * a method that gets the points of the card
   * @return the point of the card
   */
  public int getPoints(){
    return points;
  }
  
  /** 
   * a method that overides the toString method that returns a string representation
   * @return the String representation of the card
   */
  @Override 
  public String toString(){
    if (this.getPoints() == 0)//if the card has does not have a defult point value, use *
      return this.getName() + ", " + this.getGroup() + ": *";
    else
    return this.getName() + ", " + this.getGroup() + ": " + this.getPoints();
  }
}