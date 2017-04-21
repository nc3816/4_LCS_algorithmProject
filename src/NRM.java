/**
 * NRM.java
 * This class implement the Naive Recursive with memoization
 * @author Na Cui
 * @author Zhenlin Xu
 * @version 4 
 */
public class NRM {
	
	// The 2D-arrays store the sub-soluations
	private static Integer[][] memoization;
	static int i, j;
	/**
	 * Translate the String into char arrays and call the recursive method
	 * @param x     the string1
	 * @param y     the string2
	 * @return      length of the LCS
	 */
	public static int LCSNaiveMemoized(String x, String y){
		// translate the String into char arrays
		char[] string1 = x.toCharArray();
		char[] string2 = y.toCharArray();
		// Length of Arrays.
		i = string1.length;
		j = string2.length;
        
		// Initialize memoization
		memoization = new Integer[i+1][j+1];
		return lcsNaiveMemoize(string1, string2, i, j);
	}
	/**
	 * Naive Recursive with memozation 
	 * @param string1   the sequence1
	 * @param string2   the sequence2
	 * @param i         the length of string1
	 * @param j         the length of string2
	 * @return
	 */
	private static int lcsNaiveMemoize(char[] string1, char[] string2, int i, int j) {
		// check if there exist a solution previously
		if(!(memoization[i][j]==null)){
			return memoization[i][j];
		}
		else if(i == 0 || j == 0){
			memoization[i][j]=0;
			return memoization[i][j];
		}
		else if(string1[i-1]==string2[j-1]){
			memoization[i][j]=1+lcsNaiveMemoize(string1,string2,i-1,j-1);
			return memoization[i][j];
		} 
		else {			 
			memoization[i][j]=lcsNaiveMemoize(string1, string2, i, j - 1)>lcsNaiveMemoize(string1, string2, i - 1, j)?lcsNaiveMemoize(string1, string2, i, j - 1):lcsNaiveMemoize(string1, string2, i - 1, j);
			return memoization[i][j];
		}
	}
}