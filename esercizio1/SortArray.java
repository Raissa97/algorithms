package esercizio1;

import java.util.ArrayList;
import java.util.Comparator;

  /**
  * 
  *author@ Paganone
  *
  *@param <T>: type of the elements in my arraay
  */

public class SortArray<T>{
  private ArrayList<T> array=null;
  private Comparator<? super T> comparator;

  /**
  * Constructor of SortArray.
  * @param comparator: a comparator implementing the relation 
  * between the elements into the array
  */
  public SortArray(Comparator<? super T> comparator){
    this.array= new ArrayList<>();
    this.comparator= comparator;
  }

  /**
  * method which help us to know if the array
  * is empty or not.
  * @return: true if and only if the array is empty
  */
  public boolean isEmpty(){
    return(this.array).isEmpty();
  }
    
  /**
  * this method says us the length of the array.
  * @return: the lenght of the array
  */
  public int size(){
    return (this.array).size();
  }

  /**
  * This method is used to add an element into
  * our array.
  * @param: the element to be added 
  * @throw: the element can't be null  
  */
  public void addEl (T element) throws SortArrayException{
    if (element==null)
      throw new SortArrayException("add: the element cannot be NULL");
    (this.array).add(element);
  }

  /**
  * This method is used to get the element in the position
  * we want (which is the parameter of the method)
  * @param position: the position of the element we want
  * @throw: the position can't be higher or equal to the array lenght
  * @return: the element in the position specified
  */
  public T getElement(int position) throws SortArrayException {
    if(position < 0 || position >= (this.array.size()))
      throw new SortArrayException("getElement: the position of this element doesn't exist");
    return (this.array).get(position);
  }

  /**
  * this method is used to set the element of type T
  * in the position specified in the parameter.
  * @param position: the position in which we want to push the element
  * @param element: the element which has to be insert
  * @throw: the position and the element have to respect the rules
  */
  public void setPosition(int position, T element) throws SortArrayException{
    if(position < 0 || position>=(this.array.size()) || element==null)
      throw new SortArrayException("setPosition: posizion higher the array lenght or element is null");
    (this.array).set(position,element);
  }

  /**
  * This method is used to sort the array whith the
  * insertion sort.
  * @param array: the array to be sorted with insertion sort
  * @throw: the array can't be null
  */

  public void insertionSort(SortArray <T> array)throws SortArrayException{
    if(array == null)
      throw new SortArrayException("insertion: Array can't be NULL");
    int lenght = array.size();   
    if(lenght > 1){          
      T temp;
      int j=0;
      for(int i= 1; i<lenght; i++){
        temp=array.getElement(i);
        j=i;
        while(j>0 && ((this.comparator).compare(temp,array.getElement(j-1)))<0){
          array.setPosition(j,array.getElement(j-1));
          j=j-1;
        }
          array.setPosition(j,temp);
      }
    }        
  }  
  
  /**
  * This method is used to split the array in little parts.
  * Then it calls mergo which is the method that sort
  * the array.
  * @param startIndex & endIndex: they allow us to split the array into atomic elements
  * @throw: the array can't be null
  */
  public void mergeSort(int startIndex, int endIndex)throws SortArrayException{
    if(startIndex < endIndex && (endIndex - startIndex) >= 1){
      int mid = (endIndex + startIndex)/2;
      mergeSort(startIndex, mid);
      mergeSort(mid+1, endIndex);  
      merge(startIndex,mid,endIndex);
    }
  }
	
  /**
  * this method is used to sort the array with merge sort.
  * (divide: the array is divided in little parts (with the 
  * method mergeSort) et impera: then it's sorted with recursion)
  * @param startIndex: the start of the index of the current array
  * @param midIndex: the middle index of the current array
  * @param endIndex: the end index of the current array
  */
  private void merge(int startIndex, int midIndex, int endIndex) throws SortArrayException{
    ArrayList<T> mergedSortedArray	= new ArrayList<>();
	int leftIndex = startIndex;
    int rightIndex = midIndex+1;
    while(leftIndex <= midIndex && rightIndex <= endIndex){
      if(comparator.compare(this.array.get(leftIndex), this.array.get(rightIndex)) <= 0){
        mergedSortedArray.add(this.array.get(leftIndex));
        leftIndex++;
      }else{ //if left > right
        mergedSortedArray.add(this.array.get(rightIndex));
        rightIndex++;
      }
    }       
    while(leftIndex <= midIndex){
      mergedSortedArray.add(this.array.get(leftIndex));
      leftIndex++;
    }
    while(rightIndex <= endIndex){
      mergedSortedArray.add(this.array.get(rightIndex));
      rightIndex++;
    }
    int i = 0;
    int j = startIndex;
    while(i < mergedSortedArray.size()){
      this.array.set(j, mergedSortedArray.get(i++));
      j++;
	}
  }
}