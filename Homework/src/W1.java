import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
/**
 * 
 * This class reads a text file and calculates the number of lines, words, characters.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/09/2014
 * 
 */
public class W1 {
	 /**
	   * The main program.
	   *
	   * @param    args    command line arguments (ignored)
	   */
    public static void main( String[] args ) {
        readFile();
    }
	/**
     * Read the file and calculate the total lines, word count, printable characters.
     * @param
     * @return
     */
	public static void readFile(){
    	Scanner sc = null;
		int numberOfLines =0;
		int words =0;
		String text = "";
    	try {
    		 sc  = new Scanner( new File("macbeth.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			numberOfLines++;
    			StringTokenizer st = new StringTokenizer(line, " ");
    			int tempWords = st.countTokens();
    			words = words + tempWords;
    			text = text + line;
    		}
    		System.out.println(text);    	
        	System.out.println("Number of lines= " + numberOfLines);//number of lines
    		System.out.println("Number of words= " + words);//word count
    		System.out.println("Number of printable characters= " + text.length());//total printable characters
    		sc.close();
    		countOfCharacters(text);
    		
    	} catch ( Exception e )	{
    		
    		System.err.println("Something went wrong!" + e.getMessage());
    	}
    }
	
	/**
     * Calculates the count of each character. We have used a character array and it has all the unique elements
       then we compare it with the text.
     * @param
     * @return  
     */
	public static void countOfCharacters (String text){  
		int i,j,k,l;
		int c=0;  
		char[] temp=new char[text.length()];
	      for(l=0;l<text.length();l++)
	      temp[l]=text.charAt(l);
	      for(i=0;i<l;i++)
	      {
	          char ch=temp[i];
	          for(j=i+1;j<l;j++)
	          {
	              if(temp[j]==ch)// making sure the array has unique elements
	              {
	                  for(k=j;k<(l-1);k++){
	                	  temp[k]=temp[k+1]; //if we encounter a duplicate value then delete it and reduce the size of the array 
	                  }                  
	                  l--;
	                  j=i;
	              }
	          }
	      }
	      for(i=0;i<l;i++)
	      {
	          for(j=0,c=0;j<text.length();j++)
	          {
	              if(temp[i]==text.charAt(j))// compare the characters
	              c++;
	          }
	          System.out.print(temp[i]+"=:"+c+"\n");// print
	      }
	

}
}
