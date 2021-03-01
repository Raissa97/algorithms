/package esercizio3;

import java.util.ArrayList;

/**
 * Class to implement a min-priority queue with a heap in an ArrayList.
 * 
 * @author Paganone
 */
public class HeapMinPQ<E extends Comparable<E>> implements MinPriorityQueue<E> {
  private ArrayList<E> heap;

  /**
  *  Constructor of HeapMinPQ
  */
  public HeapMinPQ() {
    heap = new ArrayList<E>();
  }
  
  /**
  * Method which helps us to know if the priorityqueue is empty or not.
  * @return: true if the queue is empty, false if it is'nt empty.
  */
  public boolean isEmpty() {
	return heap.size() == 0;
  }
  
  /**
  * Insert an element into the priority queue and keep the heap in order
  * @param elem: the element which has to be insert
  */
  public void insert(E elem) {
	heap.add(elem);        // Put new value at end;
	int loc = heap.size()-1;  // and get its location
	while (loc > 0 && heap.get(loc).compareTo(heap.get(parent(loc))) < 0) {
	  swap(heap, loc, parent(loc)); //swap with parent until parent is smaller
	  loc = parent(loc);
	}
  }

  /**
  * Method which returns the element with the minimum key
  * without removing it from the queue.
  * @return: the element with the minimum key, or null if queue empty.
  */
  public E min() {
	if (heap.size() <= 0)
	  return null;
	else
	  return heap.get(0);
  }
  
  /**
  * This method returns the element with the minimum key, and remove
  * it from the queue.
  * @return: the element with the minimum key or null if 
  * the queue is empty.
  */
  public E extractMin() {
	if (heap.size() <= 0)
	  return null;
	else {
	  E min = heap.get(0);  //the minimum element is in the first position
	  heap.set(0, heap.get(heap.size()-1)); //Move last to position 0
	  heap.remove(heap.size()-1); //remove the minimum element
	  minHeapify(heap, 0);
	  return min;
	}
  }

  /**
  * Restore the min-heap property.  When this method is called, the max-heap
  * property holds everywhere, except possibly at node i and its children.
  * When this method returns, the max-heap property holds everywhere.
  * @param arr: the list to sort
  * @param i: the position of the possibly bad spot in the heap
  */
  private static <E extends Comparable<E>> void minHeapify(ArrayList<E> arr, int i) {
	int left = leftChild(i);    // index of node i's left child
	int right = rightChild(i);  // index of node i's right child
	int smallest;    // will hold the index of the node with the smallest element
					// among node i, left, and right
	if (left <= arr.size()-1 && arr.get(left).compareTo(arr.get(i)) < 0)
	  smallest = left;   // the left child has an element smaller than "smallest"
	else
	  smallest = i;   //the left child hasn't an element larger than "largest",
	           		  //so i is the larger element.
	if (right <= arr.size()-1 && arr.get(right).compareTo(arr.get(smallest)) < 0)
	  smallest = right;  // the right child has an element smaller than "smallest"
	if (smallest != i) {
	  swap(arr, i, smallest); //swap i with smallest
	  minHeapify(arr, smallest); // hapify
	}
  } 

  /**
  * Swap two locations i and j in ArrayList a.
  * @param arr: the arrayList
  * @param i: first position
  * @param j: second position
  */
  private static <E> void swap(ArrayList<E> arr, int i, int j) {
	E tmp = arr.get(i);
	arr.set(i, arr.get(j));
	arr.set(j, tmp);
  }

  /**
  * This method returns the index of i's left child.
  * @param i: index of the node which is the parent of the left node 
  * of which we return the index
  * @return: index of the left child of i
  */
  private static int leftChild(int i) {
	return 2*i + 1;
  }

  /**
  * This method returns the index of i's right child.
  * @param i: index of the node which is the parent of the right node 
  * of which we return the index
  * @return: the index of the right child of i
  */
  private static int rightChild(int i) {
	return 2*i + 2;
  }

  /**
  * This method returns the index of the parent of i.
  * @param i: index of the node which is the child of the node 
  * of which we return the index.
  * @return: index of the parent of i
  */
  private static int parent(int i) {
	return (i-1)/2;
  }

  /**
  * The main where I try some methods
  */
  public static void main (String [] args)  {
	MinPriorityQueue<Integer> pq2 = new HeapMinPQ<Integer>();
	System.out.println("Empty??: " + pq2.isEmpty());
	pq2.insert(5);
	pq2.insert(8);
	pq2.insert(1);
	pq2.insert(9);
	pq2.insert(10);
	System.out.println("RightChild(1): " + rightChild(1));
	System.out.println("Parent(i): " + parent(6));
	System.out.println("Empty??: " + pq2.isEmpty());
	System.out.println("The smallest is: " + pq2.min());
	System.out.println("Extract min: " + pq2.extractMin());
	System.out.println("Next smallest is: " + pq2.min());
	System.out.println("Extract min: " + pq2.extractMin());
	System.out.println("Next smallest is: " + pq2.min());
	System.out.println("Extract min: " + pq2.extractMin());
	System.out.println("Next smallest is: " + pq2.min());
  }
}