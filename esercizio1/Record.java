package esercizio1;

  /**
  * @author: Paganone
  */

public class Record{
  private long longField;

  /**
  * constructor of Record
  */
  public Record(long longField){
    this.longField = longField;
  }
  
  /**
  * method getLongField:
  * @return: the longField of the record.
  */
  public long getLongField(){
    return this.longField;
  }
}