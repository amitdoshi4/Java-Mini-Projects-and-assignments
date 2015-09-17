import java.io.*;
/**
 * This class is a markup class
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 11/24/2014
 * 
 */
public class JavaMarkUp {
	/**
	* The main program.
	*
	* @param    args    command line arguments 
	*/
  public static void main( String args[] ) {
    BufferedReader input;
    PrintWriter    output;

    if ( args.length != 2 )	{
	System.err.println("Usage: java JavaMarkUp inpout output");
	System.exit(1);
    }

    try {
    	String[] words;
    	String line;
    	String outLine = "";
    	String keywords[] ={"assert","break","boolean","true","class","const","continue","default","do","double","else","enum","final","finally"
    			,"float","for","goto","if","implements","import","instanceOf","int","interface","long","main","native","new","package",
    			"private","protected","public","return","short","static","super","switch","synchronized","this","throw","throws",
    			"try","void","volatile","while"};
	input = new BufferedReader( new FileReader(args[0]));
	output = new PrintWriter(  new FileWriter(args[1]) ) ;

    	while ( ( line = input.readLine() )  != null ) {
    		words = line.split(" ");
    		for(int i = 0; i<words.length;i++)
    		{     for(int j = 0; j<keywords.length;j++){
    				if(words[i].equals(keywords[j])){
    					words[i] = "\f3"+ words[i]+ "\fp";
   
    		}
    		}
    				outLine =outLine + " " + words[i];
    	}
    		output.println(outLine);
    		outLine = "";

    }
    	output.close();
    	input.close();
    	System.out.println("DONE WITH MARKUP!");
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

  }
}