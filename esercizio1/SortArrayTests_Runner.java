package esercizio1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

  /**
  * @author Paganone
  *
  *
  * class which runs the tests in SortArrayTests.
  * It returns "true" if the tests are all correct + "number of 
  * tests" which it has run, else it returns "false" +
  * "number of tests" which it has run and we could know
  * which test has failed and why.
  */
  
public class SortArrayTests_Runner {
    
  /**
  * @param args: the command line arguments
  */
  public static void main(String[] args){
    Result result = JUnitCore.runClasses(SortArrayTests.class);
    for (Failure failure : result.getFailures()){
      System.out.println(failure.toString());
    }
    System.out.println(" final result = " + result.wasSuccessful() + "   number of run tests = " + result.getRunCount());
  }
}