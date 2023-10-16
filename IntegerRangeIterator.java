import java.util.Iterator;
import java.util.NoSuchElementException;

/** An iterator that runs through all the integers in a range of integers */
public class IntegerRangeIterator implements Iterator<Integer> {
  /** The range of integer */
  private IntegerRange range;
  
  /** The next value to be output by the iterator */
  private int value;
  
  /**
   * Create a new iterator for an IntegerRange.
   * @param range the IntegerRange that this iterator will iterate over
   */
  public IntegerRangeIterator(IntegerRange range) {
    this.range = range;
    this.value = range.getMinimum();
  }
  
  /**
   * Returns true if the iterator has more integers in the range, and false if the iterator has reached the range maximum
   * @return true if the iterator has not reached the end of the integer range
   */
  public boolean hasNext() {
    return value <= range.getMaximum();
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