package esercizio3;

import java.util.ArrayList;

  /**
  * Class to implement a max-priority queue with a heap in an ArrayList.
  * 
  * @author Paganone
  */
public class HeapMaxPQ<E extends Comparable<E>> implements MaxPriorityQueue<E> {
  private ArrayList<E> heap;
  /**
  *  Constructor of HeapMaxPQ
  */
  public HeapMaxPQ() {
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
	int i = heap.size()-1;  // and get its location
	while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) > 0) {
      swap(heap, i, parent(i)); // Swap with parent until parent larger
	  i = parent(i); 
	}
  }
  
  /**
  * Method which returns the element with the maximum key
  * without removing it from the queue.
  * @return: the element with the maximum key, or null if queue empty.
  */
  public E max() {
	if (heap.size() <= 0)
	  return null;
	else
	  return heap.get(0);
  }

  /**
  * This method returns the element with the maximum key, and remove
  * it from the queue.
  * @return: the element with the maximum key or null if 
  * the queue is empty.
  */
  public E extractMax() {
	if (heap.size() <= 0)
	  return null;
	else {
	  E max = heap.get(0); //the maximum element is in the first position
	  heap.set(0, heap.get(heap.size()-1));  // Move last to position 0
	  heap.remove(heap.size()-1); //remove the maximum element
	  maxHeapify(heap, 0);
	  return max;
	}
  }

  /**
  * Restore the max-heap property.  When this method is called, the max-heap
  * property holds everywhere, except possibly at node i and its children.
  * When this method returns, the max-heap property holds everywhere.
  * @param arr: the list to sort
  * @param i: the position of the possibly bad spot in the heap*/
  
  private static <E extends Comparable<E>> void maxHeapify(ArrayList<E> arr, int i) {
	int left = leftChild(i);
	int right = rightChild(i);
	int largest;
	if (left <= arr.size()-1 && arr.get(left).compareTo(arr.get(i)) > 0)
	  largest = left;
	else
	  largest = i;
	if (right <= arr.size()-1 && arr.get(right).compareTo(arr.get(largest)) > 0)
	  largest = right;
	if (largest != i) { 
	  swap(arr, i, largest);
	  maxHeapify(arr, largest);
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
	arr.set(i, arr.get(j)); //set i in the place of j
	arr.set(j, tmp); //and j in the place of i
  }

  /**
  * This method returns the index of i's left child.
  * @param i: index of the node which is the parent of the left node 
  * of which we return the index
  * @return: index of the left child of i
  */
  private static int leftChild(int i) {
	return 2*i + 1; //if I started from H[1]=root, I would do 2*i
  }

  /**
  * This method returns the index of i's right child.
  * @param i: index of the node which is the parent of the right node 
  * of which we return the index
  * @return: the index of the right child of i
  */
  private static int rightChild(int i) {
	return 2*i + 2; //if I started from H[1]=root, I would do 2*i+1
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
	MaxPriorityQueue<Integer> pq = new HeapMaxPQ<Integer>();
	System.out.println("Empty??: " + pq.isEmpty());
	pq.insert(50);
	pq.insert(8);
	pq.insert(1);
	pq.insert(10);
	pq.insert(99);
	pq.insert(99);
	pq.insert(78);
	System.out.println("RightChild(1): " + rightChild(1));
	System.out.println("Parent(i): " + parent(6));
	System.out.println("Empty??: " + pq.isEmpty());
	System.out.println("The biggest is: " + pq.max());
	System.out.println("extr max: " + pq.extractMax());
	System.out.println("Next biggest	is: " + pq.max());
	System.out.println("extr max " + pq.extractMax());
	System.out.println("next biggest is: " + pq.max());
	System.out.println("extr max " + pq.extractMax());
	System.out.println("next biggest is: " + pq.max());
	System.out.println("extr max " + pq.extractMax());
	System.out.println("next biggest is: " + pq.max());
	System.out.println("extr max " + pq.extractMax());
	System.out.println("next biggest is: " + pq.max());
	System.out.println("extr max " + pq.extractMax());
	System.out.println("next biggest is: " + pq.max());
	System.out.println("extr max " + pq.extractMax());
	System.out.println("Empty??: " + pq.isEmpty());
	System.out.println("next biggest is: " + pq.max());
	System.out.println("extr max " + pq.extractMax());
	MaxPriorityQueue<String> pq2 = new HeapMaxPQ<String>();
	pq2.insert("ci");
	pq2.insert("ciao");
	pq2.insert("beh");
	pq2.insert("mondo");
	pq2.insert("a");
	pq2.insert("ok");
	System.out.println("Empty??: " + pq2.isEmpty());	
	System.out.println("next biggest is: " + pq2.max());
    System.out.println("extr max " + pq2.extractMax());
	System.out.println("next biggest is: " + pq2.max());
	System.out.println("extr max " + pq2.extractMax());
	System.out.println("next biggest is: " + pq2.max());
	System.out.println("extr max " + pq2.extractMax());
	System.out.println("next biggest is: " + pq2.max());
	System.out.println("extr max " + pq2.extractMax());
	System.out.println("next biggest is: " + pq2.max());
	System.out.println("extr max " + pq2.extractMax());
	System.out.println("next biggest is: " + pq2.max());
	System.out.println("extr max " + pq2.extractMax());
  }
}