
/**
 * This class displays the various combinations of a given input variables.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 08/31/2014
 * 
 */

public class Combination {
	
	 /**
	   * The main program.
	   *
	   * @param    args    command line arguments (ignored)
	   */

	public static void main(String[] args) {
		
		     
		       //String array of input objects(a,b,c,d)
		       String input[] = {"d","c", "b","a",};
		     
		       //form the power set
		       StringBuffer finalSet = generatePowerset(input);
		     
		       //display the power set
		       System.out.println(finalSet.toString());
		     
		   }
		 
		   /**
		     * Returns the power set from the given set by using a binary counter
		     * @param input The input string array
		     * @return StringBuffer
		     */
		   private static StringBuffer generatePowerset(String[] input) {
		     
		       //create the empty subset
			   StringBuffer subset = new StringBuffer();
		     
		       //get the number of elements in the set
		       int elements = input.length;//
		     
		       //the number of members of a power set is 2^n
		       int powerElements = (int) Math.pow(2,elements);//
		     
		       //run a binary counter for the number of power elements
		       for (int i = 0; i < powerElements; i++) {
		         
		           //store the binary(n bits Ex.00,01..) representation of a number into a string binary 
		           String binary = intToBinary(i, elements);
		         
		           //create a temp set
		           StringBuffer temp = new StringBuffer();
		         
		           //convert each digit in the current binary number to the corresponding element
		            //in the given set for ex. 00 ={}, 01 = {b}
		           //run the for loop to the length of the bits representation. Ex. 00 =2, 001=3
		           for (int j = 0; j < binary.length(); j++) {
		               if (binary.charAt(j) == '1')
		            	   temp.append(input[j]);
		           }
		         
		           //add the new set to the power set
		           if(subset.length()>0){
		        	   subset.append(",");
		           }
		           subset.append("{");
		           subset.append(temp);
		           subset.append("}");
		         
		       }
		     
		       return subset; //return the subset
		   }
		   
		   /**
		     * Converts the given integer to a String representing a binary number
		     * with the specified number of digits
		     * For example when using 4 digits the binary 1 is 0001
		     * @param binary int
		     * @param digits int
		     * @return String
		     */
		   private static String intToBinary(int binary, int numberOfElements) {
		     
		       String temp = Integer.toBinaryString(binary);
		       int foundDigits = temp.length();
		       String returner = temp;
		       //adding 0 bit before the bit representation.So to make the length of binary representation = total number of input elements
		      for (int i = foundDigits; i < numberOfElements; i++) {
		           returner = "0" + returner;
		       }
		     
		         return returner;
		   }

	}


