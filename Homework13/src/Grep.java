import java.util.regex.*;
import java.io.*;

/**
 * This class evaluates the command grep 'pattern' file \;
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 11/24/2014
 * 
 */
public class Grep {
  /** The pattern we're looking for */
  static protected Pattern pattern;
  /** The matcher for this pattern */
  static protected Matcher matcher;

  /**
  * The main program.
  *
  * @param    args    command line arguments 
  */
  public static void main(String[] args) throws Exception {

    if (args.length < 1) {
        System.err.println("Usage: Grep pattern [filename]");
        System.exit(1);
    }
    pattern = Pattern.compile(args[0]);


    Grep grep = new Grep();

    if (args.length == 1)
      grep.process(new BufferedReader(new InputStreamReader(System.in)),
        "(standard input)", false);
    else
      for (int i=1; i<args.length; i++) {
        grep.process(new BufferedReader(new FileReader(args[i])),
          args[i], true);
      }
  }


  /** Do the work of scanning one file
   * @param ifile BufferedReader object already open
   * @param fileName String Name of the input file
   * @param printFileName Boolean - true to print filename
   * before lines that match.
   */
  public void process(
    BufferedReader inputFile, String fileName, boolean printFileName) {

    String inputLine;

    try {
      while ((inputLine = inputFile.readLine()) != null) {
    	    matcher = pattern.matcher(inputLine);
        if (matcher.matches()) {
          if (printFileName) {
            System.out.print(fileName + ": ");
          }
          System.out.println(inputLine);
        }
      }
      inputFile.close();
    } 
    catch (IOException e) 
    { 
    	System.err.println(e); 
    	}
  }
}
