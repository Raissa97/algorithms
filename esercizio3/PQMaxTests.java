package esercizio3;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paganone
 * 
 * 
 * class where we do some tests to verify if the methods
 * of pqmax work correctly.
 */
public class PQMaxTests {
    
  private Integer i1, i2, i3, i4, i5;
  private HeapMaxPQ<Integer> pq;
    
  /**
   * first of all we have to create our new pq.
   */
  @Before
  public void createMaxPQ(){
    i1 = 0;
    i2 = 96;
    i3 = 73;
	i4 = 22;
	i5 = 2;
    pq = new HeapMaxPQ<Integer>();
  }

  /**
  * case 1: pq is empty
  */
  @Test
  public void testIsEmpty_zeroEl(){
    assertTrue(pq.isEmpty()); //true
  }

  /**
  * case 2: pq has 1 element
  */
  @Test
  public void testIsEmpty_oneEl() throws Exception{
    pq.insert(i1);
    assertFalse(pq.isEmpty()); //false
  }

  /**
  * case 3: pq is empty --> the max doesn't exsist
  */
  @Test
  public void testMax_zeroEl(){
    assertEquals(null,pq.max()); //null
  }

  /**
  * case 4: pq has one element which is also the maximum one.
  */
  @Test
  public void testMax_oneEl() throws Exception{
    pq.insert(i1);
    assertEquals(i1,pq.max()); //i1
  }

  /**
  * case 5: pq has one element and we extract it
  */ 
  @Test
  public void testExtrMax_oneEl() throws Exception{
    pq.insert(i3);
    assertEquals(i3,pq.extractMax()); //i3
	assertTrue(pq.isEmpty()); //true
  }

  /**
  * case 6: pq has 3 element, we extract the maximum one.
  */
  @Test
  public void testExtrMax_threeEl() throws Exception{
    pq.insert(i1);
	pq.insert(i4);
	pq.insert(i5);
    assertEquals(i4,pq.extractMax()); //i4
  }
    
  /**
  * case 7: pq has 5 elements, we return the maximum one.
  */
  @Test
  public void testMax_fiveEl() throws Exception{
    pq.insert(i5);
    pq.insert(i1);
    pq.insert(i3);
	pq.insert(i4);
	pq.insert(i2);
    assertEquals(i2,pq.max()); //i2
  }
 
  /**
  * case 8: pq has 5 elements: we extract the maximum one
  * then we return the max.
  */
  @Test
  public void testMax_fiveEl_Extr() throws Exception{
    pq.insert(i5);
    pq.insert(i1);
    pq.insert(i3);
	pq.insert(i2);
	pq.extractMax();
	pq.insert(i4);
    assertEquals(i3,pq.max()); //i3
  }   
}