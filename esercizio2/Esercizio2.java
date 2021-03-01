package esercizio2;
/**
* 
* @author: Paganone
* 
*/

public class Esercizio2{
	
  public static String rest(String s){
    return s.substring(1);
  }
	
  /**
  * recursive method which calculate the edit distance
  * between two strings.
  * @param s1: the first "correct" string
  * @param s2: the second string 
  * @return: the edit distance between them
  */
  public static int edit_distance(String s1, String s2){
	int dist = 0;
	int dnoop = 0;
	int dcanc = 0;
	int dins = 0;
	int inf = Integer.MAX_VALUE;
    if(s1.length() == 0){
	  return s2.length();
	} else if (s2.length() == 0){
	  return s1.length(); 
	} else{
      if(s1.charAt(0) == s2.charAt(0)){
	    dnoop = edit_distance(rest(s1), rest(s2));
	  }else {
		dnoop = inf;
	  }
	  dcanc = 1 + edit_distance(s1,rest(s2));
      dins = 1 + edit_distance(rest(s1), s2);
	}
	return Math.min(Math.min(dnoop, dcanc), dins);
  }
  
  /**
  * method edit_distance_dyn: dynamic and iterative
  * @param s1: the "correct" string
  * @param s2: the string which has to be compared with
  * the first one.
  * The method creates a matrix and compares the characters of s1
  * with those of s2.
  * @return: the value in the angle of the matrix which is the
  * edit distance between s1 and s2.
  * This method is faster than the previous one.
  */
  public static int edit_distance_dyn(String s1, String s2){
	int[][] m = new int[s1.length()+1][s2.length()+1];
	int j = 0;
	int i = 0;
	m[0][0] = 0;
	if(j == 0){
	  for(int b = 1; b <= s1.length(); b++){
	    m[b][0] = b;
	  }
	}
	if(i == 0){
	  for(int a = 1; a <= s2.length(); a++){
	    m[0][a] = a;
	  }
	}
	for(j = 1; j < s2.length()+1; j++){
	  for(i = 1; i < s1.length()+1; i++){
	    if(s1.charAt(i-1) == s2.charAt(j-1)){
		  m[i][j] = m[i-1][j-1];
		} else{
		  m[i][j] = Math.min(m[i-1][j], m[i][j-1])+1;
		}
	  }
	} return m[s1.length()][s2.length()];
  }
  
  /**
   * main where I try some methods
   */
  public static void main (String[]args){
	String s1 = new String("colore");
	String s2 = new String("colazione");
	System.out.println("edit_dist_DYN:  " + edit_distance_dyn(s1,s2));
	System.out.println("edit_dist:  " + edit_distance(s1,s2));
  }
}