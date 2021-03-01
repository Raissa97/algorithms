package esercizio2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

  /**
  *
  * @author Paganone
  */
public class Es2TestsRunner {
    
  /**
  * method that prints final result "true" or "false"
  * and the number of run tests
  * @param args: the command line arguments
  */
  public static void main(String [] args){
    Result result = JUnitCore.runClasses(Es2TestsEdit.class);
    for (Failure failure : result.getFailures()){
       System.out.println(failure.toString());
    }
    System.out.println("final result: " + result.wasSuccessful() + "   number of run tests = " + result.getRunCount());
  }
}