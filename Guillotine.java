import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import java.lang.IllegalArgumentException;

/**
 * a class that represents the game and the display
 *  @author Ruby Lin
 */

public class Guillotine extends Application {
  /** a linklist that represent the cards player 1 collect*/
  private LinkedList<Card> player1deck = new LinkedList<Card>();
  /** a linklist that represent the cards player 2 collect*/
  private LinkedList<Card> player2deck = new LinkedList<Card>();
  /** an integer that represents player 1 points*/
  private int player1point = 0;
  /** an integer that represents player 2 points*/
  private int player2point = 0;
  /** the gameplay elements of the game that includes all the cards*/
  private Gameplay game = new Gameplay();
  /** the number of cards in the main deck.*/
  private static int numCards = 20; 
  private int initialCards = getNumCards(); 

  
  /**
   * returns the number of cards in the main deck
   * @return the number of cards in the main deck
   */
  
  public int getNumCards(){
    return numCards; 
  }
  
  /**
   * set the number of cards
   * @param num the number of cards wanted in the deck*/
  public static void setNumCards(int num){
    numCards = num; 
  }
  
   /**
    * return the Gameplay in the class
    * @return the Gameplay in the class
    */
  public Gameplay getGameplay(){
    return game; 
  }
  
  /**
   * a method that setsup the display
   * @param primaryStage the stage of the display
   */
  public void start(Stage primaryStage) {
    game.getDeck().keepUntil(numCards);

    
    //create buttons for the start of the game where there are 20 buttons representing the card
    TilePane tilepane = new TilePane(Orientation.VERTICAL);
    tilepane.setPrefRows(getNumCards());  //set row to number of cards
    tilepane.setHgap(10.0);
    tilepane.setVgap(5.0);
    Button[] b  = new Button[getNumCards()]; //create buttons that are equal to the number of the cards in the deck
    for (int i = 0; i < getNumCards(); i++) {//iterate through all cards in the deck
      if (game.getDeck().getnthNode(i)  == null)//if there is no card, show nothing on the button 
        b[i] =  new Button("");
      else 
        b[i] = new Button(game.getDeck().getnthNode(i).getElement().toString()); //the ith button will show the ith card in the list 
      tilepane.getChildren().add(b[i]);//add the button to the tilepane
    }
    tilepane.setAlignment(Pos.TOP_CENTER);

    
    
    //create player 1 info and buttons
    VBox player1 = new VBox(); //a vbox for player1
    VBox info1 = new VBox(); //a vbox for informations on the top left
    VBox buttons1 = new VBox(); //a vbox to layout the buttons
    VBox player1Cards = new VBox(); //a vbox to contain the collected cards 
    Color red = Color.RED; 
    Color black = Color.BLACK;
    Label player1Info = new Label("Player 1 \nScore:" + player1point);
    player1Info.setTextFill(red); //set the text of player 1 red indicating player 1 will start first 
    info1.getChildren().add(player1Info); //add the lable
    //createpplayer 2 info
    VBox player2 = new VBox();
    VBox info2 = new VBox();
    VBox buttons2 = new VBox();
    VBox player2Cards = new VBox();
    Label player2Info = new Label("Player 2 \nScore:" + player2point);
    player2Info.setTextFill(black);
    info2.getChildren().add(player2Info);
    //all buttons for player 1
    VBox collect1 = new VBox();
    //create a button that moves the first card in the deck back 4 cards 
    Button a1  = new Button("Move Front Back 4");
    a1.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)//if the display of the info is black, it means it is not player1's turn and button would not work
          System.out.println("It\'s not your turn!"); //it is the same for all buttons 
        else{
          a1.setDisable(true);//disable the button once it is clicked 
          getGameplay().getDeck().moveBack(4); //move the card back by 4 in the linklist 
          for (int i = 0; i < getNumCards(); i++) {//regenerate the buttons for the new card list
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    //a button that moves the front back 3
    Button a2  = new Button("Move Front Back 3");
    a2.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          a2.setDisable(true);//disable the button
          getGameplay().getDeck().moveBack(3); //change the card deck
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    //a button that moves the front back 2
    Button a3  = new Button("Move Front Back 2");
    a3.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          a3.setDisable(true);
          getGameplay().getDeck().moveBack(2);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    //a button that moves fron back 1
    Button a4  = new Button("Move Front Back 1");
    a4.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          a4.setDisable(true);
          getGameplay().getDeck().moveBack(1);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    //a button that moves the first card to the last card 
    Button a5  = new Button("Move Front to Last");
    a5.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          a5.setDisable(true);
          getGameplay().getDeck().moveFirstToLast();
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    //a button that ,oves the lst card to the front card 
    Button a6  = new Button("Move Last to Front");
    a6.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          a6.setDisable(true);
          getGameplay().getDeck().moveLasttoFirst();
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    //a button that reverse the list
    Button a7  = new Button("Reverse List");
    a7.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          a7.setDisable(true);
          getGameplay().getDeck().reverseList();
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    //a button that reverse the first five element of the list
    Button a8  = new Button("Reverse First 5"); 
    a8.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          a8.setDisable(true);
          getGameplay().getDeck().reverseFirstK(5);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    //a button that changes the round to the other player 
    Button a9  = new Button("Skip Turn");
    a9.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          player1Info.setTextFill(black);//change the color of both players
          player2Info.setTextFill(red);
        }
      }
    });
    //a method that teakes the first card in the deck into the player deck
    Button a10  = new Button("Take First Card");
    a10.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player1Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          player1Info.setTextFill(black);//change the color
          player2Info.setTextFill(red);
          Card c = getGameplay().getDeck().removeFromFront();//remove the first card from the main deck and record the card
          setNumCards(getNumCards()-1);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null){
              b[i].setText("");
              b[i].setVisible(false);//if the card has no element make it not visible by the player 
            }
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
          for(int i  = getNumCards(); i < initialCards; i++){
            b[i].setText("");
            b[i].setVisible(false); //set the buttons not visible after the list
          }
          Button newcard = new Button(c.toString()); //add a new button that represents the card added to the player deck
          player1deck.addToFront(c); //add card c to the player deck
          player1Cards.getChildren().add(newcard);
          player1point = countPoint(player1deck);//count player 1's point 
          player1Info.setText("Player 1 \nScore:" + player1point);//show the new point after the change 
          //if the game has no more cards in the main deck, it ends by showing a window that shows who wins that the statistics of the game 
          if(getGameplay().getDeck().isEmpty()){
            VBox end = new VBox();
            Label endLabel1 = new Label("Player 1 wins!\nStatistics: \nplayer 1 :" + player1point + "\nplayer 2: " + player2point);
            Label endLabel2 = new Label("Player 2 wins!\nStatistics: \nplayer 1: " + player1point + "\nplayer 2: " + player2point);
            Label endLabel3 = new Label("It\'s a tie!\nStatistics: \nplayer 1: " + player1point + "\nplayer 2: " + player2point);
            if(player1point > player2point)
              end.getChildren().add(endLabel1);
            else if (player2point > player1point)
              end.getChildren().add(endLabel2);
            else 
              end.getChildren().add(endLabel3);
            primaryStage.setScene(new Scene(end, 500, 500));//set the scene to the end scene 
            primaryStage.setTitle("GUILLOTINE!");
            primaryStage.show();
          }
        }
      }
    });
    //add the button and information to the vbox 
    buttons1.getChildren().addAll(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    
    Label labela = new Label("People Collected:");
    player1.getChildren().add(info1);
    player1.getChildren().add(buttons1);
    player1.getChildren().add(labela);
    player1.getChildren().add(player1Cards);
    
    
    //create the rightside player 2 info and buttons with the same method as player 1
    Button b1  = new Button("Move Front Back 4");
    b1.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          b1.setDisable(true);
          getGameplay().getDeck().moveBack(4);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    
    Button b2  = new Button("Move Front Back 3");
    b2.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          b2.setDisable(true);
          getGameplay().getDeck().moveBack(3);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    
    Button b3  = new Button("Move Front Back 2");
    b3.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          b3.setDisable(true);
          getGameplay().getDeck().moveBack(2);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    
    Button b4  = new Button("Move Front Back 1");
    b4.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          b4.setDisable(true);
          getGameplay().getDeck().moveBack(1);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    
    Button b5  = new Button("Move Front to Last");
    b5.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          b5.setDisable(true);
          getGameplay().getDeck().moveFirstToLast();
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    
    Button b6  = new Button("Move Last to Front");
    b6.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          b6.setDisable(true);
          getGameplay().getDeck().moveLasttoFirst();
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    
    Button b7  = new Button("Reverse List");
    b7.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          b7.setDisable(true);
          getGameplay().getDeck().reverseList();
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    
    Button b8  = new Button("Reverse First 5");
    b8.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          b8.setDisable(true);
          getGameplay().getDeck().reverseFirstK(5);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null)
              b[i].setText("");
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
        }
      }
    });
    
    Button b9  = new Button("Skip Turn");
    b9.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          player2Info.setTextFill(black);
          player1Info.setTextFill(red);
        }
      }
    });
    
    Button b10  = new Button("Take First Card");
    b10.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e) {
        if(player2Info.getTextFill() == black)
          System.out.println("It\'s not your turn!");
        else{
          player2Info.setTextFill(black);
          player1Info.setTextFill(red);
          Card c = getGameplay().getDeck().removeFromFront();
          setNumCards(getNumCards()-1);
          for (int i = 0; i < getNumCards(); i++) {
            if (game.getDeck().getnthNode(i)  == null){
              b[i].setText("");
              b[i].setVisible(false);
            }
            else 
              b[i].setText(game.getDeck().getnthNode(i).getElement().toString());
          }
          for(int i  = getNumCards(); i < initialCards; i++){
            b[i].setText("");
            b[i].setVisible(false);
          }
          
          Button newcard = new Button(c.toString());
          player2deck.addToFront(c);
          player2Cards.getChildren().add(newcard);
          player2point = countPoint(player2deck);
          player2Info.setText("Player 2 \nScore:" + player2point);
          
          if(getGameplay().getDeck().isEmpty()){
            VBox end = new VBox();
            Label endLabel1 = new Label("Player 1 wins!\nStatistics: \nplayer 1: " + player1point + "\nplayer 2: " + player2point);
            Label endLabel2 = new Label("Player 2 wins!\nStatistics: \nplayer 1: " + player1point + "\nplayer 2: " + player2point);
            Label endLabel3 = new Label("It\'s a tie!\nStatistics: \nplayer 1: " + player1point + "\nplayer 2: " + player2point);
            if(player1point > player2point)
              end.getChildren().add(endLabel1);
            else if (player2point > player1point)
              end.getChildren().add(endLabel2);
            else 
              end.getChildren().add(endLabel3);
            primaryStage.setScene(new Scene(end, 500, 500));
            primaryStage.setTitle("GUILLOTINE!");
            primaryStage.show();
          }
        }
      }
    });
    buttons2.getChildren().addAll(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10); //add all the buttons

    Label labelb = new Label("People Collected:");
    
    player2.getChildren().add(info2);
    player2.getChildren().add(buttons2);
    player2.getChildren().add(labelb);
    player2.getChildren().add(player2Cards);
    
    //main display
    BorderPane bp = new BorderPane();
    bp.setCenter(tilepane);
    bp.setLeft(player1);
    bp.setRight(player2);
    
    primaryStage.setScene(new Scene(bp, 500, 700));
    primaryStage.setTitle("GUILLOTINE!");
    primaryStage.show();
    
  }
  
  /**
   * counts the total points for a deck
   * @param playerDeck the deck point is counted
   * @return the number of points
   */
  public int countPoint(LinkedList<Card> playerDeck){
    int p = 0;
    for (Card card : playerDeck) {
      p = p + card.getPoints();//add all the points in the deck without the star cards
    }
    //add additional points by squaring the number of palace guards in the deck
    p = p + (playerDeck.contains(new Card("Palace Guard", "Military", 0))*playerDeck.contains(new Card("Palace Guard", "Military", 0)));
    if(playerDeck.contains(new Card("Countess", "Royal", 2)) > 0 && playerDeck.contains(new Card("Count", "Royal", 2)) > 0)
      p = p + 4; //add 4 points if the deck contains both countess and count
    if (playerDeck.contains(new Card("Lord", "Royal", 2)) > 0 && playerDeck.contains(new Card("Lady", "Royal", 2)) > 0)
      p = p + 4;//add 4 points if the deck contains both lord and lady
    if(playerDeck.contains(new Card("Heretic", "Church", 0)) > 0 && getGameplay().containsGroup(playerDeck, "Church") > 0)
      p = p + (this.getGameplay().containsGroup(playerDeck, "Church")); //if the deck contains heretic, increase the point by the number of church cards
    if(playerDeck.contains(new Card("Tax Collector", "Civic", 0)) > 0 && getGameplay().containsGroup(playerDeck, "Civic") > 0)
      p = p + (this.getGameplay().containsGroup(playerDeck, "Civic"));//if the deck containstax collector, increase the point by the number of civic cards
    if(playerDeck.contains(new Card("Tragic Figure", "Commoner", 0)) > 0 && getGameplay().containsGroup(playerDeck, "Commoner") > 0)
      p = p + (this.getGameplay().containsGroup(playerDeck, "Commoner"))*(-1);//if the deck contains tragic figure, decrease the point by the number of commoner cards
    return p; //return the number of points
  }
  
  /**
   * the main method that runs the code
   * @param args a string array
   * @throws NumberFormatException if the string can not be convert into an integer between 2 to 40
   */
    public static void main(String[] args){
      int x = 20; 
      if(args.length == 1){//if there is only 1 string in the array
        try{
          x = Integer.parseInt(args[0]); // store the string as an integer
        }catch (NumberFormatException e){//if the input is not a number
          throw new IllegalArgumentException("please enter a number between 2 to 40!");
        }
        if(x > 1 && x < 41) //set the number of cards to x if x is a valid number 
          setNumCards(x);
        else //else print an error message 
          throw new IllegalArgumentException("please enter a number between 2 to 40!");
      }
      Application.launch(args);
    }
}