/**
 * NR.java
 * This is naive recursive algorithm of LCS
 * @author Na Cui
 * @author Zhenlin Xu
 * @version 4 
 */

public class NR {	
	/**
	 * translate the String into char arrays
	 */
	public static int LCSNR(String x, String y){	
		// translate the String into char arrays
		char[] string1 = x.toCharArray();
		char[] string2 = y.toCharArray();
		// Length of Arrays
		int i = string1.length;
		int j = string2.length;
		
		return NaiveLcs(string1, string2, i, j);
	}
	/**
	 * Naive Recursive of LCS
	 * @param char1            the string1's char arrays
	 * @param char2			   the string2's char arrays
	 * @param char1Length	   the length of char1
	 * @param char2Length      the length of char2
	 * @return
	 */
	public static int NaiveLcs(char[] char1, char[] char2, int char1Length, int char2Length){
		if (char1Length == 0 || char2Length == 0){
			return 0;
		}
		if (char1[char1Length-1] == char2[char2Length - 1]){
			return 1 + NaiveLcs(char1, char2, char1Length- 1, char2Length - 1);
		}	
		else{
			return NaiveLcs(char1, char2, char1Length, char2Length-1) > NaiveLcs(char1, char2, char1Length-1, char2Length)
					?NaiveLcs(char1, char2, char1Length, char2Length-1) : NaiveLcs(char1, char2, char1Length-1, char2Length);
		}		
	}
}