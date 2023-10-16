import java.util.NoSuchElementException;
/**
 * A class to represent a linked list of nodes.
 * @author Ruby Lin
 */
public class LinkedList<T> implements Iterable<T>{
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    firstNode = null;
  }
  
  /**
   * Returns the first node.
   * @return the first node of the list
   */
  protected LLNode<T> getFirstNode() {
    return firstNode;
  }
  
  /**
   * Prints the contents of a list to System.out.
   * @return a string representation of the linklist
   */
  public String printList() {
    String s = "";
    for (T element : this) {
      s = s + element.toString();
    }
    return s; 
  }
    
  /**
   * Changes the front node.
   * @param node  the node that will be the first node of the new linked list
   */
  protected void setFirstNode(LLNode<T> node) {
    this.firstNode = node;
  }
  
  /**
   * a method that overides the iterator method
   * @return the linkedListiterator of the first node.
   */
  @Override
  public LinkedListIterator<T> iterator() {
    return new LinkedListIterator<T>(getFirstNode());
  }
  
  
  
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirstNode() == null);
  }
  
  /**
   * Add an element to the front of the linked list
   * @param element the element to add to the front
   */
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  
  /**
   * Removes and returns the element at the front of the linked list
   * @return the element removed from the front of the linked list
   * @throws NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFirstNode().getElement();
      setFirstNode(getFirstNode().getNext());//set the first node to the second node 
      return save;
    }
  }
  
  /**
   * Adds an element to the end of the linkd list
   * @param element the element to insert at the end
   */
  public void addToEnd(LLNode<T> node) {
    if (isEmpty())
      addToFront(node.getElement());
    else {
      LLNode<T> nodeptr = getFirstNode();
      while (nodeptr.getNext() != null) //add the node to the end when the pointer is at the last node
        nodeptr = nodeptr.getNext();
      nodeptr.setNext(node);
    }
  }
  
  /** 
   * a method that returns the number of elements stored in the list
   * @return the number of elements stored in the list
   */
  public int listLength(){
    int count = 0; 
    if(isEmpty())
      return 0; 
    LLNode<T> nodeptr = getFirstNode();
    while (nodeptr.getNext() != null){//iterate to the last node and record the number of iteration
      count ++; 
      nodeptr = nodeptr.getNext();
    }
    return count+1; //return number of node in the list
  }
  
  /**
   * Moves the frst node to the list back n places
   * @param n the number of places that the first node moves
   */
  public void moveBack(int n){
    int count = 0; //int to count 
    LLNode<T> add = null; //store the node after the place is moved
    if(n >= this.listLength())//there are not at least n+1 nodes in the list, the method does not change the list
      ;
    else {
      LLNode<T> nodeptr = getFirstNode();
      while (count < n ){//loop until the pointer get to the position to move the first no to
        count ++; 
        nodeptr = nodeptr.getNext();
      }
      add = nodeptr.getNext();//store the node after the place is moved
      nodeptr.setNext(new LLNode<T> (getFirstNode().getElement(), null)); //set next node to a new node that is equivalent to the firts node
      nodeptr.getNext().setNext(add); //set the node after the added node to add
      setFirstNode(getFirstNode().getNext());//set the first node to the second node
    }
  }
  
  /**
   * moves the first node to become the last node of the list
   */
  public void moveFirstToLast(){
    moveBack(listLength()-1);//move back to the last place
  }
  
  /**
   * remove the Last node
   */
  public void removeLastNode(){
    LLNode<T> nodeptr = getFirstNode();
    if(listLength() == 1)//if there is only 1 node list is not changed
      ;
    else{
      while (nodeptr.getNext().getNext() != null){//if the nodeptr is at the second to last node, set next node to null
        nodeptr = nodeptr.getNext();
      }
      nodeptr.setNext(null);
    }
  }
  
  /**
   * the last node of the list is now the first node, and the rest of the nodes of the list are unchanged.
   */
  public void moveLasttoFirst(){
    int count = 0; 
    LLNode<T> nodeptr = getFirstNode();
    while (nodeptr.getNext() != null){ //iterate to the last node
      count ++; 
      nodeptr = nodeptr.getNext(); 
    }
    addToFront(nodeptr.getElement()); //add the last node to front
    removeLastNode(); //remove the last node
  }
  
  /** 
   *  reverses all the nodes of the list.
   */
  public void reverseList(){
     LLNode<T> prev = null; //a node to record the previous node in the list
     LLNode<T> next = null; //a node to record the next node
     LLNode<T> current = getFirstNode();//a node pointer to record the current node
     int i = 0; 
     int end = listLength();
     while (i < end) {
       next = current.getNext(); //record the next node
       current.setNext(prev); //set the next node to the previous node to reverse the list
       prev = current; //the new previous node to the current node
       current = next; //set the current node to the next node
       i++;
     }
     setFirstNode(prev); //set the first node the the previous node after loop is complete
  }
  
  /**
   * reverses the first k nodes of the linked list. 
   * @param k the first k nodes of the linked list that are reversed. 
   */
  public void reverseFirstK(int k){//method is same as reverselist except of reverse the first k node
    LLNode<T> prev = null; 
    LLNode<T> next = null; 
    LLNode<T> current = getFirstNode();
    LLNode<T> nodeptr = getFirstNode();
    int i = 0; 
    int count = 0;
    if(k >= this.listLength())//there are not at least n+1 nodes in the list, the method does not change the list
      ;
    else {
      while (count < k){ //iterate until the node that is not going to be reversed
        count ++; 
        nodeptr = nodeptr.getNext();
      }
      while (i < k) {
        next = current.getNext();
        current.setNext(prev);
        prev = current;
        current = next;
        i++;
      }
      setFirstNode(prev);
      addToEnd(nodeptr); //add the unchanged part to the end
    }
  }
  
  /** 
   * a method that shuffles the list
   */
  public void shuffle(){
    int random = 0; 
    LLNode<T> nodeptr = getFirstNode();
    for (int i = 0; i < listLength(); i++){
      random = (int) 1 + (int)(Math.random() * listLength());//create a random integer from 1 to listlength
      moveBack(random);//move the node back a random vale
      if(1 + (int)(Math.random() * 10) != 0)
        reverseList();//randomly reverse the list
      nodeptr = getFirstNode();
    }
  }
  
  /**
   * a method that gets the nth node
   * @param n the nth node
   * @return a node that is located at the nth place
   */
  public LLNode<T> getnthNode(int n){
    LLNode<T> nodeptr = getFirstNode();
    if(n >= listLength())
      return null; 
    else{
    for(int i = 0; i < n; i++ )//iterate to the nth place
      nodeptr = nodeptr.getNext();
    return nodeptr;
    }
  }
  
  /** 
   * keep the first n element in the list
   * @n the length of lest to keep
   */
  public void keepUntil(int n){
    if (n >= listLength()) //if n is greater than the list, keep everything
      ;
    else if(n == 0)
      this.setFirstNode(null);
    else{
      for (int i = listLength(); i > n; i--){
        this.removeLastNode();//remove the last node until there is only n number of node left
      }
    }
  }
  
  /** 
   * count the number of element the list contains
   * @param element the element that we want to find in the list
   */
  public int contains(T element){
    LLNode<T> nodeptr = getFirstNode();
    int i = 0; 
    while (nodeptr!= null){ 
      if(nodeptr.getElement().toString().equals(element.toString()))
        i++; //increase i by 1 if the pointer is equal to the node
      nodeptr = nodeptr.getNext();
    }
    return i; 
  }
}


  