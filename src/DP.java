import java.util.*;
/**
 * DP.java
 * Using dynamic programming method to compute LCS
 * @author Na Cui
 * @author Zhenlin Xu
 * @version 4 
 */
public class DP{  
	/**
	 * This method is dynamic programming method
	 * @param value 	the table of the marked the value 
	 * @param path		the table to store the value path
	 * @param res		store the LCS sequence
	 * @param result	
	 * @return 
	 */
	public static int[][] DPLength(String string1, String string2) {
		int[][] value = new int[string1.length() + 1][string2.length() + 1];   
        int[][] path = new int[string1.length()+1][string2.length()+1];
        for(int i=1;i<=string1.length();i++){
            value[i][0]=0;
            //if the path is blank, marked as 0;
            path[i][0]=0;
        }
        for(int j=0;j<=string2.length();j++){
            value[0][j]=0;
            path[0][j]=0;
        }
        // compute the tables by bottom-up
        for (int i =1;i<=string1.length(); i++){  
            for (int j = 1;j<=string2.length(); j++){  
            	//go diagonally
                if (string1.charAt(i-1) == string2.charAt(j-1)) {
                    value[i][j] = value[i-1][j-1] + 1;
                    //marked "Diagonally" as 1
                    path[i][j] =1;
                    }  
                //go up
                else if(value[i-1][j]>=value[i][j-1]){
                    value[i][j] = (value[i-1][j]);  
                    //marked "Up" as 2
                    path[i][j] =2;
                }
                //go left
                else {
                	value[i][j] = (value[i][j-1]);  
                	//marked "Left" as 3
                    path[i][j] =3;
                }
            }  
        }
        return path;
	}
        /**
		 * recursive the longest common sequence and print it
		 * @param string1    the sequence1
		 * @param string2    the sequence2
		 * @param path       the table store the path of the recursive
		 * @return           the result of the LCS 
		 */
        public static String DPprint(String string1, String string2, int[][] path){
        	ArrayList<Character> res = new ArrayList<Character>();
            int i=string1.length();
            int j=string2.length();
            while(i>=0 && j>=0){
            	if(path[i][j]==1){
            		res.add(string1.charAt(i-1));
            		i--;
            		j--;
            	}
            	else if(path[i][j]==2){i--;}
            	else{j--;}
            }
            // Reverse the results
            Collections.reverse(res);
            // Convert the ArrayList to a String
            String result = new String();
            for (i=0;i<res.size();i++){
            	result+=res.get(i);
            }
    		return result;
    	} 
}  
    


