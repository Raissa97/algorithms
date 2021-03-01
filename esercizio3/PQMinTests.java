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
* class to try some tests for each case.
*/
public class PQMinTests {
    
  private Integer i1, i2, i3, i4, i5;
  private HeapMinPQ<Integer> pq;
  
  /**
  * first of all i create my new minpq
  */
  @Before
  public void createMinPQ(){
    i1 = 0;
    i2 = 96;
    i3 = 73;
	i4 = 22;
	i5 = 2;
    pq = new HeapMinPQ<Integer>();
  }
   
  /**
  * case 1: pq is empty
  */
  @Test
  public void testIsEmpty_zeroEl(){
    assertTrue(pq.isEmpty()); //true
  }
   
  /**
  * case 2: pq has 1 element so it isn't empty.
  */
  @Test
  public void testIsEmpty_oneEl() throws Exception{
    pq.insert(i1);
    assertFalse(pq.isEmpty()); //false
  }

  /**
  * case 3: pq is empty so the minimum key doesn't exsist
  */
  @Test
  public void testMin_zeroEl(){
    assertEquals(null,pq.min()); //null
  }
    
  /**
  * case 4: pq has 1 element which is also the minimum one
  */
  @Test
  public void testMin_oneEl() throws Exception{
    pq.insert(i1);
    assertEquals(i1,pq.min()); //i1
  }

  /**
  * case 5: pq has 1 element which is also the minimum one.
  * we extract it and then pq must be empty.
  */
  @Test
  public void testExtrMin_oneEl() throws Exception{
    pq.insert(i3);
    assertEquals(i3,pq.extractMin()); //i3
  }
 
  /**
  * case 6: pq has 3 elements: we extract the minimum one
  */
  @Test
  public void testExtrMin_threeEl() throws Exception{
    pq.insert(i1);
	pq.insert(i4);
	pq.insert(i5);
    assertEquals(i1,pq.extractMin()); //i1
  }
    
  /**
  * case 7: pq has 5 elements: we search the minimum one.
  */
  @Test
  public void testMin_fiveEl() throws Exception{
    pq.insert(i5);
    pq.insert(i1);
    pq.insert(i3);
	pq.insert(i4);
	pq.insert(i2);
    assertEquals(i1,pq.min()); //i1
  }
	
  /**
  * case 8: pq has 5 elements: we extract the minimum, then
  * we return the minimum element (which can't be the one 
  * we extracted before)
  */
  @Test
  public void testMin_fiveEl_Extr() throws Exception{
    pq.insert(i5);
    pq.insert(i1);
    pq.insert(i3);
	pq.extractMin();
	pq.insert(i4);
	pq.insert(i2);
    assertEquals(i5,pq.min()); //i5
  }   
}