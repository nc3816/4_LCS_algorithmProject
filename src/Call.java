import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Call.java
 * Call the 4 LCS algorithms separately and collect the data
 * @author Na Cui
 * @author Zhenlin Xu
 * @version 4
 */
public class Call {
	public static void main(String []args) throws Exception{
        int LCSNRlength;
        int LCSNRMlength;
        int LCSDPlength;
        int LCSHlength;
        String string1 = "",string2="";
        // defined LCS string
        String LCSDP= new String();
        String LCSH = new String();
        
        //read the files 
         Scanner s1 = new Scanner(new File("/Users/nacui/Desktop/abcd/s1.txt"));
		 while(s1.hasNextLine()){
			 string1 = s1.nextLine();
		 }
		 Scanner s2 = new Scanner(new File("/Users/nacui/Desktop/abcd/s2.txt"));
		 while(s2.hasNextLine()){
			 string2 = s2.nextLine();
		 }
	    // Call the callDP method in class DP to compute LCS using the dynamic programming method
		for (int i=0;i<10;i++)
		{	
			//i times of NR
			LCSNRlength = NR.LCSNR(string1, string2);
			System.out.println("LCSNRlength："+LCSNRlength);
		
			//i times of NRM
			LCSNRMlength = NRM.LCSNaiveMemoized(string1, string2);
			System.out.println("LCSNRMlength："+LCSNRMlength);

			//i times of DP
			LCSDP=DP.DPprint(string1, string2,DP.DPLength(string1,string2));
			LCSDPlength= LCSDP.length();
			System.out.println("LCSDPlength: "+LCSDPlength);
			System.out.println("LCSDP："+ LCSDP);

			//i times of Hirschberg
			LCSH = Hirschberg.HirschbergC(string1.length(), string2.length(), string1, string2);
			LCSHlength = LCSH.length();
			System.out.println("LCSHlength："+ LCSHlength);
			System.out.println("LCSH: "+LCSH);
		}
	}
}
