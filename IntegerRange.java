import java.util.Iterator;
import java.util.NoSuchElementException;
/** An inclusive range of integers [minimum, maximum] */
public class IntegerRange implements Iterable<Integer> {
  /** The minimum value of this integer range */
  private final int minimum;
  
  /** The maximum value of this integer range */
  private final int maximum;
  
  /**
   * Create a range of integers: [minimum, maximum
   * @param minimum the smallest integer in the range
   * @param maximum the largest integer in the range
   */
  public IntegerRange(int minimum, int maximum) {
    this.minimum = minimum;
    this.maximum = maximum;
  }
  
  /**
   * Return the smallest integer in the range
   * @return the minimum integer of the range
   */
  public int getMinimum() {
    return minimum;
  }
  
  /**
   * Return the largest integer in the range
   * @return the maximum integer of the range
   */
  public int getMaximum() {
    return maximum;
  }
  
  /**
   * Returns an iterator that iterates through the integers of the range from the minimum to the maximum
   * @return an iterator that iterates through the integers of the range from the minimum to the maximum
   */
  public IntegerRangeIterator iterator() {
    return new IntegerRangeIterator();
  }
  
  public void printList(){
    for(Integer i: this)
      System.out.println(i);
  }
  
  private class IntegerRangeIterator implements Iterator<Integer> {
    
    /** The next value to be output by the iterator */
    private int value;
    
    /**
     * Create a new iterator for an IntegerRange.
     * @param range the IntegerRange that this iterator will iterate over
     */
    public IntegerRangeIterator() {
      this.value = getMinimum();
    }
    
    /**
     * Returns true if the iterator has more integers in the range, and false if the iterator has reached the range maximum
     * @return true if the iterator has not reached the end of the integer range
     */
    public boolean hasNext() {
      return value <= getMaximum();
    }
    
    /**
     * Returns the next integer in the IntegerRange, starting from the minimum
     * @return the next integer in the IntegerRange
     * @throws NoSuchElementException if the iteration has reached the maximum value of the IntegerRange
     */
    public Integer next() {
      if (!hasNext())
        throw new NoSuchElementException();
      else
        return value++;
    }
  }  
}