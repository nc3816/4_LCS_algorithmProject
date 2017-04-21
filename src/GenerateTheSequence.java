/**
 * GenerateTheSequence.java
 * Generate the sequence by random method
 * Or download the current DNAs sequence from the NCBI
 * Or generate the special sequences by manual
 *
 * @author Na Cui
 * @author Zhenlin Xu
 * @version 4
 */
import java.util.*;
public class GenerateTheSequence {
    /**
     * generate the random a pair of element of ATCG sequences
     * @param length       the length set by the user
     * @return             a pair of random sequences
     */
    public static String GetRandomStrings(int length)
    {
        
        StringBuffer buffer = new StringBuffer("ATCG");
        StringBuffer buffer = new StringBuffer("AB");
        StringBuffer buffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        StringBuffer buffer = new StringBuffer("01");
        StringBuffer stringBuffer = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++)
        {
            stringBuffer.append(buffer.charAt(r.nextInt(range)));
        }
        return stringBuffer.toString();
    }
    /**
     * get the string sets
     */
    public static void main(String []args){
        //		 define the length of strings
        int stringLength = 50000;
        //    	 Generate the random strings with defined length
        String String1 = GenerateTheSequence.GetRandomStrings(stringLength);
        String String2 = GenerateTheSequence.GetRandomStrings(stringLength);
    }
}