package esercizio1;
import java.util.Comparator;
  /**
  * @author: Paganone
  */
public class ComparatorInt implements Comparator<Record>{
	
  /**
  * override of method compare: it compares 2 records
  * (element1 and element2)
  * = ascending order
  * and return the result in int.
  */
  @Override
  public int compare(Record element1, Record element2){
    int result=(new Long(element1.getLongField())).compareTo(element2.getLongField());
    return result;
  }  
}