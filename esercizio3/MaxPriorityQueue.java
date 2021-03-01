package esercizio3;
/**
 * The interface for the max-priority queue.
 * 
 * @author Paganone
 */
public interface MaxPriorityQueue<E extends Comparable<E>> {
	
  /**
   * This method is used to know if the priority queue is empty or not.
   * @return: true if the priority queue is empty, false if it isn't empty.
   */
  public boolean isEmpty();
  
  /**
   * This method insert the element "elem" into the queue.
   * @param elem: the element which has to be insert
   */
  public void insert(E elem);
  
  /**
   * This method is used to return the element with the maximum key, 
   * without removing it from the queue.
   * @return: the element with the minimum key in the priority queue
   */
  public E max();
  
  /**
   * This method is used to return the element with the maximum key removing it from the queue.
   * @return: the element with the minimum key in the priority queue
   */
  public E extractMax();
}