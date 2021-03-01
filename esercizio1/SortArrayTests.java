package esercizio1;

import java.util.Comparator;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

  /**
  * @author Paganone
  * class where I try some tests in order to see if
  * my methods work correctly for every case.
  */
 
public class SortArrayTests{
	 
  class IntegerComparator implements Comparator<Integer>{
	  
    /**
    * Override of the method "compare"
    * @param i1, i2: integers to be compare
    */
    @Override
    public int compare(Integer i1, Integer i2){
      return i1.compareTo(i2);
    }
  }/**inner class*/
    
  private Integer i1, i2, i3, i4, i5;
  private SortArray<Integer> array;
   
  /**
  * I create the array
  */  
  @Before
  public void createSortArray(){
    i1 = 1;
    i2 = 2;
    i3 = 33;
	i4 = 78;
	i5 = 99;
    array = new SortArray<>(new IntegerComparator());
  }
  
  /**
  * case 1: the array hasn't elements
  */
  @Test
  public void testIsEmpty_zeroEl(){
    assertTrue(array.isEmpty());
  }
    
  /**
   * case 2: the array has 1 element so it is'nt empty
   */
  @Test
  public void testIsEmpty_oneEl() throws Exception{
    array.addEl(i1);
    assertFalse(array.isEmpty());
  }
  
  /**
   * case 3: the array is empty --> size = 0
   */
  @Test
  public void testSize_zeroEl(){
    assertEquals(0,array.size());
  }
  
  /**
   * case 4: the array has 1 element
   */
  @Test
  public void testSize_oneEl() throws Exception{
    array.addEl(i1);
    assertEquals(1,array.size());
  }
    
  /**
   * case 5: the array has 2 elements --> size = 2
   */
  @Test
  public void testSize_twoEl() throws Exception{
    array.addEl(i1);
    array.addEl(i2);
    assertEquals(2,array.size());
  }
	
  /**
   * case 6: the array has 1 element and we do the insertion sort
   */
  @Test
  public void testInsertion_oneEl()throws Exception{
	array.addEl(i1);
	array.insertionSort(array);
	Integer[] arrExpected = {i1};
	Integer[] arrActual = new Integer[1];
	arrActual[0]=array.getElement(0);
	assertArrayEquals(arrActual,arrExpected);
  }

  /**
   * case 7: the array has more than 1 element and we do 
   * the insertion sort. the array must be sorted.
   */
  @Test
  public void testInsertion_moreEl()throws Exception{
	array.addEl(i5);
	array.addEl(i3);
	array.addEl(i1);
	array.addEl(i4);
	array.addEl(i2);
	array.insertionSort(array);
	Integer[] arrExpected = {i1, i2, i3, i4, i5};
	Integer[] arrActual = new Integer[5];
    for (int i=0; i<5; i++)
      arrActual[i] = array.getElement(i);
    //System.out.println("  Arr actual NUOVO ARR" + Arrays.toString(arrActual));
	//System.out.println("  Arr Expected GIUSTO " + Arrays.toString(arrExpected));
	assertArrayEquals(arrActual,arrExpected);
  }

  /**
   * case 8: the array has 1 element and we do the mergesort
   */
  @Test
  public void testMerge_oneEL()throws Exception{
    array.addEl(i1);
	array.mergeSort(0,array.size()-1);
	Integer[] arrExpected = {i1};
	Integer[] arrActual = new Integer[1];
	arrActual[0]=array.getElement(0);
	assertArrayEquals(arrActual,arrExpected);
  }

  /**
   * case 9: the array has more than 1 element and we do
   * de merge sort so it must be ordered.
   */
  @Test
  public void testMerge_moreEl()throws Exception{
	array.addEl(i5);
	array.addEl(i3);
	array.addEl(i1);
	array.addEl(i4);
	array.addEl(i2);
	array.mergeSort(0,array.size()-1);
	Integer[] arrExpected = {i1, i2, i3, i4, i5};
	Integer[] arrActual = new Integer[5];
    for (int i=0; i<=4; i++){
      arrActual[i] = array.getElement(i);
    }
	//System.out.println("  Arr actual " + Arrays.toString(arrActual));
	//System.out.println("  Arr Expected " + Arrays.toString(arrExpected));
	assertArrayEquals(arrActual,arrExpected);
  }
  
  /** HOW TO COMPILE:
  * 
  * javac -cp .;..\junit-4.12.jar; ..\hamcrest-core-1.3 sortArray\*.java
  *
  *  HOW TO RUN:
  * in package sort
  * java -cp .;..\junit-4.12.jar;..\hamcrest-core-1.3.jar SortArrayTests_Runner
  *
  */
}	
 