package esercizio1;

/**
 * 
 * @author Paganone
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Scanner;

public class SortArrayUsage{
  private static final Charset ENCODING = StandardCharsets.UTF_8;
  private static final int seconds = 600;
    
  /**
  * method which prints the first 100 elements in the array
  * @param array: the array to be printed
  */
  private static void printArray(SortArray<Record> array)throws SortArrayException, IOException{
    Record currEl = null;
    int sizeArr;
    System.out.println("Firts 100 elements of the ordered arrray");
    sizeArr=array.size();
    for(int i=0; i<100;i++){
      currEl=array.getElement(i);
      System.out.println(currEl.getLongField());
    }
  }

  /**
  * method which help us to load an array.
  * @param array: the array where we'll put the elements of the file
  * @param filepath: the path where we bring the elements of the array
  */
  private static void loadArray(String filepath, SortArray<Record> array) throws SortArrayException, IOException{
    System.out.println("LOADING DATA FROM FILE...");
    Path inputFilePath=Paths.get(filepath);
    try(BufferedReader fileInputReader =
      Files.newBufferedReader(inputFilePath, ENCODING)){
      String line=null;
      while((line=fileInputReader.readLine()) != null){
        Record element=new Record(Long.parseLong(line));
        array.addEl(element);
      }
    }
  }

  /**
  * method which does the insertionsort of the array printing the time
  * @param filepath: the path of the file where we bring the elements
  * @param comparator: the comparator to use
  */
  private static void insertionSort(String filepath,Comparator<Record> comparator)throws SortArrayException, IOException{
    SortArray<Record> array=new SortArray<>(comparator);
    loadArray(filepath,array);
	TimeChecker time = new TimeChecker(seconds);
	time.printStartTime();
    array.insertionSort(array);
    printArray(array);
	time.printEndTime();
	System.exit(0);
  }

  /**
  * method which does the mergesort and prints the times.
  * @param filepath: the path of the file where we bring the elements  
  * @param comparator: the comparator to use
  */
  private static void mergeSort(String filepath,Comparator<Record> comparator)throws SortArrayException, IOException{
    SortArray<Record> array=new SortArray<>(comparator);
    loadArray(filepath,array);	
	TimeChecker time = new TimeChecker(seconds);
	time.printStartTime();		
    array.mergeSort(0,array.size()-1);				
    printArray(array);
    System.out.println("FATTO");
	time.printEndTime();
	System.exit(0);
  }

  /**
  * main where I try the previous methods.
  */
  public static void main(String [] args) throws SortArrayException, IOException{
    if(args.length < 1)
      throw new SortArrayException("Usage: OrderedArrayUsageJava <file_name>");
      Scanner scanner = new Scanner(System.in);
	  System.out.print("What method?? \n");
	  System.out.print(" '1': MergeSort       '2' : InsertionSort \n");
	  int number = scanner.nextInt();
	  int ordine;
	if (number>2 || number<0)
	  throw new SortArrayException("This option doesn't exist!");
	  switch(number) {
		case 1:
          System.out.print("You have chosen MERGESORT \n");
		  System.out.print("Premi '1' per ordine CRESCENTE o '2' per ordine DECRESCENTE \n");
		  ordine=scanner.nextInt();
		  if(ordine==1)
		 	mergeSort(args[0], new ComparatorInt());
		  if(ordine==2)
			mergeSort(args[0], new ComparatorDec());
		  if(ordine != 1 && ordine != 2)
			throw new SortArrayException("This option doesn't exist!");			
			break;
		case 2:
		  System.out.print("You have chosen INSERTIONSORT \n");
		  System.out.print("Premi '1' per ordine CRESCENTE o '2' per ordine DECRESCENTE \n");
		  ordine=scanner.nextInt();
		  if(ordine==1)					
			insertionSort(args[0], new ComparatorInt());				
		  if(ordine==2)				
			insertionSort(args[0], new ComparatorDec());					
		  if(ordine != 1 && ordine != 2)
			throw new SortArrayException("This option doesn't exist!");
			break;
			default:
	  } //switch-case
  }
}

/**
 * HOW TO COMPILE:
 * 
 * javac esercizio1/*.java
 * 
 * HOW TO RUN:
 * in the extern folder
 * java esercizio1/SortArrayUsage "filepath of integers.csv" "filepath of sums.txt"
 * 
 */