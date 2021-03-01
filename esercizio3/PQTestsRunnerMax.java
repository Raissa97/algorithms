package esercizio3;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Paganone
 *
 * class which run the tests in PQMinTests and in
 * PQMaxTests
 * It returns true if the tests are all correct + number of 
 * tests that it has run, else it returns false.
 */
public class PQTestsRunnerMax {
    
  /**
  * @param args: the command line arguments
  */
  public static void main(String [] args){
    Result result = JUnitCore.runClasses(PQMaxTests.class);
    for (Failure failure : result.getFailures()){
      System.out.println(failure.toString());
    } 
    System.out.println(" final result = " + result.wasSuccessful() + "   number of run tests = " + result.getRunCount());
  }
} 