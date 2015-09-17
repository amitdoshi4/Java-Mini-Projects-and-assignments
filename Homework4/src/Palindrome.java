
/**
 * This Program Displays all the palindromes in a given text File.
 * 
 * Version 1.0
 * 
 * @author Swanand Pathak
 * @author Amit Doshi
 * 
 * Date: 12/09/2014
 * 
 */

import java.util.Scanner;

//import java.util.StringTokenizer;
import java.io.File;

public class Palindrome{
	 /**
	   * The main program.
	   *
	   * @param    args    command line arguments (ignored)
	   */
	public static void main( String[] args ) {
	
    	readFile();
    }
    
	public static void readFile(){
    	Scanner sc = null;    //scanner sc initialized to null 
		int count=0;		 //int count initialized to '0'
    	try {
    		 sc  = new Scanner( new File("/Volumes/Macintosh HD/Users/swanandpathak/Desktop/plain.txt"));  //sc scanner scans the txt while mentioned in the address
    		 while ( sc.hasNext() )	     //while has new line
    		 {
    			String line = sc.nextLine();  //everytime the new(next) line stored in the String line
    			line=line.toLowerCase();      //all the characters in the line converted to lowercase as example- Anna is also considered to be a palindrome 
    			System.out.println("String in this line:"+line);   //each line printed
    			for(int start=0;start<line.length();start++)       // loop from starting position of the line till the end of the line which is equal to its length
    			{
    				for(int end=line.length()-1;end>start+1;end--) //loop which goes from end of the string to 2 places ahead of the value start of the previous for loop which observes the starting postion 
    				{   
    					count=0; //to keep track of the similar characters in the string...initialised to zero
    					
    						if(line.charAt(start)==line.charAt(end))    // if first and last character same ,pass to check_palindrome function
    						{
    							count=check_palindrome(start,end,line,count); //after checking if palindrome value of count returned
    							
    						}
    						if(count==(Math.abs(start-end)+1))  // if count == difference of start and end location + 1 , it is a palindrome
    						{
    							System.out.println("Palindrome is: ");
    							System.out.print(line.substring(start,end+1));  // using substring to print the from start up to (end+1) postions 
    							System.out.println("\n");
    						}
    					}
    				}
    			}
    		
		
    		 sc.close();
    	} catch ( Exception e )	{
    		
    		System.err.println("Something went wrong!" + e.getMessage());
    	}
    }
	
	/**
     * Returns the Count of the number of times the characters 
     * @param start
     * @param end
     * @param line
     * @return count which is equal to characters which are equal when if check for palindrome
     * condition from start and end.  
     */
		
	public static int check_palindrome(int start,int end,String line,int count)
	{
		int help;
		help=start;        // the first value of start stored in help
		while(end!=help-1) // while end does not go behind(or to the left) of the start value from where string comparison started
		{
			if(line.charAt(start)==line.charAt(end)) // if characters equal
			{
				count++;	//increment count
			}
			start++;		// increment start 
			end--;			// increment end
		}
		
		
		return count;		// return count
	}
}
	