package esercizio1;
import java.util.Comparator;
  /**
  * @author: Paganone
  */
public class ComparatorDec implements Comparator<Record>{
	
  /**
  * override of method compare: it compares 2 records
  * (element2 and element1)
  * = descending order
  * and return the result in int.
  */
  @Override
  public int compare(Record element1, Record element2){
    int result=(new Long(element2.getLongField())).compareTo(element1.getLongField());
    return result;
  }  
}