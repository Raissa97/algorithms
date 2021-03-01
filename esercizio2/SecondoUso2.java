package esercizio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

  /**
  * @author: Paganone
  */
public class SecondoUso2 {   
  private static final Charset ENCODING = StandardCharsets.UTF_8;
  
  /**
   * method which helps us to load the file "correctme" that
   * is the file which contains some "wrong" words.
   */
  private static void loadCor(String filepath, ArrayList<String> array) throws IOException{
    System.out.println("LOADING DIZIONARIO FROM FILE...");
    Path inputFilePath=Paths.get(filepath);
    try(BufferedReader fileInputReader =
      Files.newBufferedReader(inputFilePath, ENCODING)){
      String line=null;
	  while ((line = fileInputReader.readLine()) != null){
        for(String retval: line.split(" ")) {
          array.add(retval);
        }
      }
    }
  }
  
  /**
   * method which helps us to load the file "dictionary" that contains the 
   * "correct" words.
   * @param filepath: the path of "dictionary.txt"
   * @param array: the arraylist where the method saves the words.
   */
  private static void loadArr(String filepath, ArrayList<String> array) throws IOException{
    System.out.println("LOADING DIZIONARIO FROM FILE...");
    Path inputFilePath=Paths.get(filepath);
	int count =0;
    try(BufferedReader fileInputReader =
      Files.newBufferedReader(inputFilePath, ENCODING)){
      String line=null;
	  while ((line = fileInputReader.readLine()) != null){
        array.add(line);
		count++;
      }
    }
  }
  
  /**
   * method to print the arraylists.
   * @param array: the array list to print
   */
  private static void printArray(ArrayList<String> array)throws IOException{
    int sizeArr;
    System.out.println("ARRAY..ARRAY..ARRAY");
    sizeArr=array.size();
    for(int i=0; i<sizeArr;i++){
      String currentEl = array.get(i);
	  System.out.println(currentEl);
    }
  }
  
  /**
   * method where we invoke "edit_distance_dyn".
   * @param a1: the first array that contains the words of dictionary
   * @param a2: the second array which contains correctme
   * @return: an array of int. every integer represents the edit distance between
   * the words.
   */
  public static int[] correttore(ArrayList<String> a1, ArrayList<String> a2){
	int[] ris = new int[a2.size()];
	int edit;
	int minedit;
	for(int i = 0; i < a2.size(); i++){
	  minedit = 100;
	  //System.out.println("cambio parola frase");
      for(int j = 0; j < a1.size(); j++){
	    edit = Esercizio2.edit_distance_dyn(a1.get(j), a2.get(i));
		//System.out.println("cambio parola diz");
		if(edit < minedit){
		  //System.out.println("aggiorno minedit");
		  minedit = edit;
		  ris[i] = minedit;
		}
		if(minedit == 0){
		  ris[i] = 0;
		  j = a1.size();
		}
	  }
	} return ris;
  }
  
  /**
   * main where I try the previous methods
   */
  public static void main (String[]args)throws IOException{
	ArrayList<String> dizionario = new ArrayList<>();
	ArrayList<String> correctme = new ArrayList<String>();
	loadArr(args[0], dizionario);
	//printArray(dizionario);
	loadCor(args[1], correctme);
	printArray(correctme);
	int[] ris = correttore(dizionario, correctme);
	for(int i = 0; i < correctme.size(); i++){
	  System.out.println(ris[i]);
	}
  }
  
  /*
  * HOW TO COMPILE:
  * javac SecondoUso2.java
  *
  * HOW TO RUN:
  * java SecondoUso2 ..\dictionary.txt ..\correctme.txt
  * 
  */
}