package esercizio1;

/**
 * 
 * @author Paganone
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class SumUsage{
  private static final Charset ENCODING = StandardCharsets.UTF_8;
    
  /**
  * method which prints the array of records
  */
  private static void printArrayInt(SortArray<Record> array)throws SortArrayException, IOException{
    Record currEl=null;
    int sizeArr;
    System.out.println("		ARRAY		");
    sizeArr=array.size();
    for(int i=0; i<sizeArr;i++){
      currEl=array.getElement(i);
      System.out.println(currEl.getLongField());
    }
  }
    
  /**
  * method which prints the array of boolean
  */
  private static void printArray(ArrayList<Boolean> array)throws SortArrayException, IOException{
    boolean currEl=false;
    int sizeArr;
    System.out.println("		ARRAY		");
    sizeArr=array.size();
    for(int i=0; i<sizeArr;i++){
      currEl=array.get(i);
      System.out.println(currEl);
    }
  }

  /**
  * method which loads the elements of a file into the array of records.
  * @param filepath: the string containing the filepath 
  * @param array: the sortArray where we save the elements of the file
  */
  private static void loadArray(String filepath, SortArray<Record> array) throws SortArrayException, IOException{
    System.out.println("LOADING DATA FROM FILE...");
    Path inputFilePath=Paths.get(filepath);
    try(BufferedReader fileInputReader =
      Files.newBufferedReader(inputFilePath, ENCODING)){
      String line=null;
      while((line=fileInputReader.readLine()) != null ){
        //System.out.println(line);
        Record element=new Record(Long.parseLong(line));
        array.addEl(element);
      }
    }
  }
    
  /**
  * @param filepath1: the path of the file "integers.csv"
  * @param filepath2: the path of "sums.txt"
  * @param comparator: the comparator 
  */  
  private static void testHasTwoElements(String filepath1, String filepath2,Comparator<Record> comparator)throws SortArrayException, IOException{
    SortArray<Record> arrayInt = new SortArray<>(comparator);
    SortArray<Record> arraySum = new SortArray<>(comparator);
    loadArray(filepath1,arrayInt);  //loading "integers.csv"
    loadArray(filepath2,arraySum); //loading "sums.txt"
    ArrayList<Boolean> risultato = new ArrayList<>();
    hasTwoElemets(arrayInt,arraySum,risultato);
    printArray(risultato);
  }

  /**
  * method which compare elements in order to see if two are the sum of the other
  * @param arrayInt: the array in which I search 2 elements wich sum gives me NO_IMPLEMENT
  * @param arraySum: the array in which my "N"s are stored
  * @param risultato: the boolean array in which i say if there are 2 element which sum is NO_IMPLEMENT
  * risultato.size()==arraySum.size()
  */

  private static void hasTwoElemets(SortArray<Record> arrayInt, SortArray<Record> arraySum, ArrayList<Boolean> risultato)throws SortArrayException, IOException{
    arrayInt.mergeSort(0,arrayInt.size()-1);
    int leftIndex=0;
    int rightIndex=arrayInt.size()-1;
    long currSum=0;
    long currLeft=0;
    long currRight=0;
    boolean trovato;
    for(int i=0;i<arraySum.size();i++){
      currSum=arraySum.getElement(i).getLongField();
      trovato=false;
      while(leftIndex<rightIndex && trovato==false){
        currLeft=arrayInt.getElement(leftIndex).getLongField();
        currRight=arrayInt.getElement(rightIndex).getLongField();
        if((currLeft+currRight)==currSum){
          risultato.add(true);
		  trovato=true;
		}
        else if ((currLeft+currRight)<currSum)
          leftIndex++;
        else
          rightIndex--;            
        }
        if(leftIndex>=rightIndex)
          risultato.add(false);
        leftIndex=0;
        rightIndex=arrayInt.size()-1;
    }
  }
  
  /**
  * main where I try some methods
  */  
  public static void main(String [] args) throws SortArrayException, IOException{
    if(args.length < 1)
      throw new SortArrayException("Usage: OrderedArrayUsageJava <file_name>");
    testHasTwoElements(args[0], args[1],new ComparatorInt());
  }
  
  /**
  * HOW TO COMPILE:
  * javac -cp .;..\junit-4.12.jar;..\hamcrest-core-3.1.jar esercizio1\*.java
  * 
  * HOW TO RUN:
  * in extern package
  * java esercizio1/SumUsage "filepath of integers.csv" "filepath of sums.txt"
  */
}