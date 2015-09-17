import java.io.*;
import java.util.ArrayList;
/**
 * This class evaluates the command find . -type f -exec grep Hello {} \;
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 11/17/2014
 * 
 */

public class Grep {
	static ArrayList<File> files = new ArrayList<File>();
	static String match;
	
/**
* The main program.
*
* @param    args    command line arguments 
*/
	
public static void main( String args[] ) {	 
    if ( args.length < 1 )	{
	System.err.println(
	     "Enter the correct number of arguments");
	System.exit(1);
    }
    match = args[0];
    System.out.println();
	listFiles(new File("."));
	  pattern();
  }

/**
* listFiles
* This list all the files and directory
*
* @param    directoryName    File
* 
* @return null
*/
public static void listFiles(File directoryName) {

	    for (File file : directoryName.listFiles()) {
	        if (file.isFile()) {
	            files.add(file);
	        } else if (file.isDirectory()) {
	            listFiles(file);
	        }
	    }
	}

/**
* pattern
* Matches the substring in the file and prints the line.
*
* @param    null
* 
* @return null
*/
private static void pattern() {
   int i =0;
	for(File l :files){
    BufferedReader input;
    try {
    	String line;
    	input = new BufferedReader(
    			  new FileReader(files.get(i))
    			          );

    	while ( ( line = input.readLine() )  != null ) {
    		if ( line.toLowerCase().indexOf(match.toLowerCase()) >= 0 )
    		{	System.out.println("Source: " + files.get(i)+" matches");
    			System.out.println(line);
    		}
    	}
	input.close();
    }
    catch ( FileNotFoundException e)	{
    	System.out.println(e.getMessage());
    }
    catch ( IOException e)	{
    	System.out.println(e.getMessage());
    }
    catch ( Exception e)	{
    	System.out.println("ExceptionType occurred: " + 
    		e.getMessage() );
    }
 i++;
	}
	
}
}