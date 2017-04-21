/**
 * Hirschberg.java
 * This class implement the Quadratic-time linear-space algorithm (Hirschberg's algorithm)
 * to solve the LCS problems
 * Using Hirschber's algorithm B and algorithm C
 * 
 * @author Na Cui
 * @author Zhenlin Xu
 * 
 * @version 1 
 */
public class Hirschberg {
	/**
	 * Using the default constrcutor
	 */
	public Hirschberg(){}
	/**
	 * Hirschberg's algorithm B
	 * @param string1Lenght         The length of the string1
	 * @param string2Length			The length of the string2
	 * @param string1				The string of the first one
	 * @param string2				The string of the second one
	 * @return k[1]                 The last line of the Needleman-Wunsch score matrix Score(i,j):
	 */
	public static int[] HirschbergB(int string1Length, int string2Length, String string1, String string2){
		int[][]k = new int[2][string2Length+1];
		for(int j=0;j<=string2Length;j++){
			k[1][j]=0;
		}
		for(int i=1;i<=string1Length;i++){
			for(int j=0;j<=string2Length;j++){
				k[0][j]=k[1][j];
			}
			for(int j=1;j<=string2Length;j++){
				if(string1.charAt(i-1)==string2.charAt(j-1)){
					k[1][j]=k[0][j-1]+1;
				}
				else{
					k[1][j]=max(k[1][j-1],k[0][j]);
				}
			}
		}
		return k[1];
	}
	/**
	 * This method decide the maximum number between two numbers
	 * @param x		number1
	 * @param y		number2
	 * @return      the maximum number
	 */
	public static int max(int x,int y){
		if(x>y){return x;}
		else{return y;}
		}
	/**
	 * Hirschberg's algorithm C
	 * @param string1Length     The length of string1
	 * @param string2Length     The length of string2
	 * @param string1           The string1
	 * @param string2           The string2
	 */
	public static String HirschbergC(int string1Length, int string2Length, String string1, String string2){
		int i=0;
		String c="";
		if(string2Length==0){
			c="";
		} else if(string1Length==1){
			c="";
			for( int j=0;j<string2Length;j++){
				if(string1.charAt(0)==string2.charAt(j)){
					c=""+string1.charAt(0);
					break;
				}
			}
		}
		else{
			i = (int)Math.floor(((double)string1Length)/2);
			int [] l1 = HirschbergB(i,string2Length,string1.substring(0,i),string2);
			int [] l2 = HirschbergB(string1Length-i,string2Length, reverseString(string1.substring(i)),reverseString(string2));
			int k = maximumK(l1,l2,string2Length);
			String c1 = HirschbergC(i,k,string1.substring(0,i),string2.substring(0,k));
			String c2 = HirschbergC(string1Length-i,string2Length-k,string1.substring(i),string2.substring(k));
			c = c1+c2;
		}
		return c;
	}
	
	/**
	 *  Reverse a string
	 *  @param input            The string need to reverse
	 *  @return output 		    The result of the reverse string
	 */
	public static String reverseString(String input){
		String output = "";
		for(int i = input.length()-1;i>=0;i--){
			output = output + input.charAt(i);
		}
		return output;
	}
	
	/**
	 * Find the maximum sum index of L1 and L2
	 * @param l1            The first part string
	 * @param l2			The second part string
	 * @return k			The maximum sum index
	 */
	public static int maximumK (int[] l1, int[] l2, int n){
		int m = 0,k=0;
		for(int j=0;j<=n;j++){
			if(m<(l1[j]+l2[n-j])){
				m=l1[j]+l2[n-j];
				k=j;
			}
		}
		return k;
	}
}
	
	

