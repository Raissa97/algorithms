package esercizio2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paganone
 */
public class Es2TestsEdit{

  private String s1, s2, s3, s4;
  
  /**
  * I create some strings in order to do 
  * a lot of tests which represents every case that
  * could happen
  */
  @Before
  public void createString(){
    s1 = "casa";
	s2 = "cassa";
	s3 = "";
	s4 = "casa";
  }
  
  /**
  * case 1: the second string is empty
  * @return: length of the first string
  * the return represents the number of insertions
  * we have to do if we want 2 equal strings
  */
  @Test
  public void testEditDistEmptyString() throws Exception{
    assertEquals(4, Esercizio2.edit_distance_dyn(s1, s3));
  }
  
  /**
  * case 2: the first string is empty
  * @return: the length of the second string
  * the return represents the number of cancellations.
  */
  @Test
  public void testEditDistEmptyOtherString() throws Exception{
   assertEquals(4, Esercizio2.edit_distance_dyn(s3, s1));
  }
  
  /**
  * case 3: the 2 strings are equals.
  * @return: 0 (because we don't do operations like 
  * cancellations or insertions)
  */
  @Test
  public void testEditDistEqualStrings() throws Exception{
    assertEquals(0,Esercizio2.edit_distance_dyn(s1,s4));
  }
  
  /**
  * case 4: strings differ in length and characters
  *@return: edit distance of the strings.
  */
  @Test
  public void testEditDistDifferentStrings() throws Exception{
    assertEquals(1,Esercizio2.edit_distance_dyn(s1, s2));
  }
	
  /*
  * HOW TO COMPILE:
  * javac -cp .;..\junit-4.12.jar;..\hamcrest-core-1.3.jar esercizio2\*.java
  *
  * HOW TO RUN:
  * java -cp .;..\junit-4.12.jar;..\hamcrest-core-1.3.jar Es2TestsRunner.java
  */
}
