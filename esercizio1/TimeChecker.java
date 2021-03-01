package esercizio1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimeChecker {
  private Timer timer;
  private String sdf = null;
	
  /**
  * Constructor of TimeChecker.
  */
  public TimeChecker(int seconds){
    this.timer = new Timer();
	this.timer.schedule(new RemindTask(), seconds * 1000);
  }
  
  /**
  * method which prints the start-time
  */
  public void printStartTime(){
	sdf = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	System.out.println("\nSorting started at: " + sdf);
  }
	
  /**
  * method which prints the end time
  */
  public void printEndTime(){
	sdf = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	System.out.println("\nSorting ended successfully at: " + sdf);
  }
	
  /**
  * method which says the time expired when the run doesn't terminate
  */
  class RemindTask extends TimerTask{
	public void run(){
      String sdf = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	  System.out.format("Sorting terminated. Time expired: " + sdf);
	  System.exit(0);
	  timer.cancel();//Terminate timer thread
	}
  }
}