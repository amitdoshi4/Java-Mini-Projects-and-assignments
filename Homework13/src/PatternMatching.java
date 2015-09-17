import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.*;
import java.io.*;

/**
 * This class evaluates the following;
 *
1  Legal Java Variable
2  Single Line Comment
3  words that start with an a and end with e
4  word combinations of two words
5  word combination of three words

 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 11/24/2014
 * 
 */
public class PatternMatching {

	static protected Pattern pattern;
	static protected Matcher matcher;
	static ArrayList<File> files = new ArrayList<File>();
	static String match;
	static String line;
	static int whichMethod;
	
	
/**
* The main program.
*
* @param    args    command line arguments 
*/
	
public static void main( String args[] ) {	 
	listFiles(new File("."));
	System.out.println("Please select from the following method ");
	System.out.println("1  Legal Java Variable ");
	System.out.println("2  Single Line Comment ");
	System.out.println("3  words that start with an a and end with e ");
	System.out.println("4  word combinations of two words ");
	System.out.println("5  word combination of three words ");
	Scanner scanner = new Scanner(System.in);
    whichMethod = scanner.nextInt();
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
    	input = new BufferedReader(new FileReader(files.get(i)));
    	if(whichMethod==1)
    	legalVariables(input, i);
    	if(whichMethod==2)
    	singleLineComment(input, i);
    	if(whichMethod==3)
    	findWord(input, i);
    	if(whichMethod==4)
    	twoWords(input,i);
    	if(whichMethod==5)
    	threeWords(input, i);	
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
/** Scan the three words
 * @param ifile BufferedReader object already open
 * @param fileName String Name of the input file
 * @param printFileName Boolean - true to print filename
 * before lines that match.
 */
private static void threeWords(BufferedReader input, int i) throws IOException {
	Pattern pattern2;
	Matcher matcher2;
	pattern = Pattern.compile("[a-zA-Z]*t$");
	pattern2 = Pattern.compile("(^[^aA|^eE|^iI|^oO|^uU][a-z])");
	matcher = pattern.matcher("");
	matcher2 = pattern2.matcher("");
	String word1;
	String word2 = "";
	String middleWord = "";
	while ( ( line = input.readLine() )  != null ) {
		StringTokenizer st1 = new StringTokenizer(line, " ");
		StringTokenizer st2;
		while(st1.hasMoreTokens()){
		word1 = (String) st1.nextElement();
		word2="";
		st2=st1;
		if(st1.hasMoreElements())
		 middleWord = (String)st2.nextElement();
		if(st2.hasMoreElements())
		word2 = (String) st2.nextElement();
		matcher.reset(word1);
		matcher2.reset(word2);
		if (matcher.lookingAt()&&matcher2.lookingAt())
		{	 System.out.println("First word ends with 't' and third starts with consonant : " + files.get(i)+" is");
			System.out.println(word1+" "+middleWord+" "+ word2);
		}
		}
	}

}

/** Match the pattern for the two words
 * @param ifile BufferedReader object already open
 * @param fileName String Name of the input file
 * @param printFileName Boolean - true to print filename
 * before lines that match.
 */
private static void twoWords(BufferedReader input, int i) throws IOException {
	Pattern pattern2;
	Matcher matcher2;
	pattern = Pattern.compile("(^[a-zA-Z]*(a$|e$|i$|o$|u$))");
	pattern2 = Pattern.compile("(^[^aA|^eE|^iI|^oO|^uU])");
	
	matcher2 = pattern2.matcher("");
	String word1;
	String word2 = "";
	while ( ( line = input.readLine() )  != null ) {
		StringTokenizer st1 = new StringTokenizer(line, " ");
		StringTokenizer st2;
		while(st1.hasMoreTokens()){
		word1 = (String) st1.nextElement();
		word2="";
		st2=st1;
		if(st1.hasMoreElements())
		word2 = (String) st2.nextElement();
		matcher = pattern.matcher(word1);
		matcher2.reset(word2);
		if (matcher.lookingAt()&&matcher2.lookingAt())
		{	 System.out.println("First word ends with a vowel and second starts with a consonant : " + files.get(i)+" is");
			System.out.println(word1+" "+ word2);
		}
		}
	}

}
/** Match the pattern for the single word
 * @param ifile BufferedReader object already open
 * @param fileName String Name of the input file
 * @param printFileName Boolean - true to print filename
 * before lines that match.
 */
private static void findWord(BufferedReader input, int i) throws IOException {
    pattern = Pattern.compile("^a[a-z]*e$");	
    String word;
	while ( ( line = input.readLine() )  != null ) {
		StringTokenizer st = new StringTokenizer(line, " ");
		while(st.hasMoreTokens()){
		word = (String) st.nextElement();
	    matcher = pattern.matcher(word);
		if (matcher.matches())
		{	 System.out.println("Words that start with an a and ends with e in file: " + files.get(i)+" is");
			System.out.println(word);
		}
		}
	}}

/** Match the pattern for the single line comments
 * @param ifile BufferedReader object already open
 * @param fileName String Name of the input file
 * @param printFileName Boolean - true to print filename
 * before lines that match.
 */
private static void singleLineComment(BufferedReader input, int i) throws IOException {

    pattern = Pattern.compile("([/][/])(.*)");
	while ( ( line = input.readLine() )  != null ) {
		matcher = pattern.matcher(line);
		if (matcher.matches())
		{	System.out.println("single line comment in file: " + files.get(i)+" are");
			System.out.println(line);
		}
	}		
}

/** Match the pattern for the legal java variables
 * @param ifile BufferedReader object already open
 * @param fileName String Name of the input file
 * @param printFileName Boolean - true to print filename
 * before lines that match.
 */
private static void legalVariables(BufferedReader input, int i) throws IOException {
	pattern = Pattern.compile("([a-z]|$|_)([a-zA-Z]|$|_|[0-9])*");
	String keywords[] ={"assert","break","class","const","continue","default","do","double","else","enum","final","finally"
			,"float","for","goto","if","implements","import","instanceOf","int","interface","long","native","new","package",
			"private","protected","public","return","short","static","super","switch","synchronized","this","throw","throws",
			"try","void","volatile","while"};
    String word;
    boolean isKeyword = false;
	while ( ( line = input.readLine() )  != null ) {
		StringTokenizer st = new StringTokenizer(line, " ");
		while(st.hasMoreTokens()){
		word = (String) st.nextElement();
		matcher = pattern.matcher(word);
		for(int j =0 ; j<keywords.length;j++) {
			if(word.equals(keywords[j]))
			isKeyword = true;	
		}   
		if (matcher.matches()&&!isKeyword){
			System.out.println("Legal java variable in file: " + files.get(i)+" is");
			System.out.println(word);
		}
		isKeyword = false;
		}
		}
	}
	
}



