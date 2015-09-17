import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This method throws a number of exceptions
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/23/2014
 * 
 */
public class Exceptions {
/**
* The main program.
*
* @param    args    command line arguments (ignored)
*/	
	public static void main(String args[]){
		Exceptions e = new Exceptions();
		aritheMaticException();
		arrayIndexOutOfBound();
		methodCastException();
		methodNotFoundException();
		e.cloneNotSupportedException();		
		indexOutOfBoundsException();
		negativeArraySizeException();
		noSuchFieldException();
		noSuchMethodException();
		nullPointerException();
		numberFormatException();
		stringIndexOutOfBoundsException();
		ioException();
		}
	
	/**
     * This method throws the ioException
     * @param 
     * @return  void
     */

	private static void ioException() {
		try {
			Scanner sc  = new Scanner( new File("Fail.txt") );
			sc.close();
		} catch ( FileNotFoundException e ) {
		    System.out.println("14. FileNotFoundException " + e);
	        }
	}
	
	/**
     * This method throws the StringIndexOutOfBoundsException
     * @param s String
     * @return  void
     */
	private static void stringIndexOutOfBoundsException() {
		try{
			String s="abcdefgh";
			s.substring(15);
		}
		catch(StringIndexOutOfBoundsException ex){
			System.out.println("13. String IndexOutOfBounds Exception " +ex);
		}	
		
	}
	/**
     * This method throws the NumberFormatException
     * @param s String
     * @param i int
     * @return  void
     */

	private static void numberFormatException() {
		try{
			String s="abc";
			int i = Integer.parseInt(s);
		}
		catch(NumberFormatException ex){
			System.out.println("12. Number Format sException " +ex);
		}	
	}
	/**
     * This method throws the nullPointerException
     * @param i int
     * @return  void
     */
	private static void nullPointerException() {
		try{
			Integer n = null;
			int i = n.intValue();
		}
		catch(NullPointerException ex){
			System.out.println("11. Null Pointer Exception " +ex);
		}	
		
	}
	/**
     * This method throws the noSuchMethodFoundException
     * @param 
     * @return  void
     */

	private static void noSuchMethodException() {
		try{
			Test t = new Test();
			t.getClass().getMethod("B");
		}
		catch(NoSuchMethodException ex){
			System.out.println("10. No Such Method Exception " +ex);
		}	
		
	}
	/**
     * This method throws the nuSuchFieldException
     * @param s String
     * @return  void
     */
	private static void noSuchFieldException() {
		try{
			Test t = new Test();
			t.getClass().getField("B");
		}
		catch(NoSuchFieldException ex){
			System.out.println("9. No Such Field Exception " +ex);
		}	
		
	}
	/**
     * This method throws the NegativeArraySizeException
     * @param i int
     * @return  void
     */
	private static void negativeArraySizeException() {
		try{
			int i =-1;
			int a[] = new int[i];
		}
		catch(NegativeArraySizeException ex){
			System.out.println("8. negative Array Size Exception " +ex);
		}	
		
	}
	/**
     * This method throws the IndexOutOfBoundsException
     * @param a String
     * @return  void
     */
	private static void indexOutOfBoundsException() {
		try{
			String a ="abc";
			a.charAt(4);
		}
		catch(IndexOutOfBoundsException ex){
			System.out.println("7. Index out Bound " +ex);
		}	
		
	}
	/**
     * This method throws the cloneNotSupportedException
     * @param 
     * @return  void
     */

	private void cloneNotSupportedException() {
		try{
			Exceptions e = new Exceptions();
			e.clone();
		}
		catch(CloneNotSupportedException ex){
			System.out.println("5. Clone not supported " +ex);
		}	
	}
	/**
     * This method throws the methodNotFoundException
     * @param 
     * @return  void
     */
	private static void methodNotFoundException() {
		try{
			Class c = Class.forName("Test1");

		}
		catch(ClassNotFoundException ex){
			System.out.println("4. method Not Found Exception " +ex);
		}		
		
	}
	/**
     * This method throws the methodCastException
     * @param 
     * @return  void
     */
	private static void methodCastException() {
		try{
			 Object obj = new Integer(100);
			 System.out.println((String) obj);

		}
		catch(Exception ex){
			System.out.println("3. method Cast Exception " +ex);
		}		
	}

	/**
     * This method throws the arrayIndexOutOfBoundsException
     * @param s String
     * @return  void
     */
	private static void arrayIndexOutOfBound() {
		try{
			int a[]= new int[5];
			a[6]=0;
		}
		catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("2. Array Index Out of Bound Exception: " +ex);
		}
		
	}
	/**
     * This method throws the arithematicException
     * @param 
     * @return  void
     */
	private static int aritheMaticException() {
		// TODO Auto-generated method stub
		try{
			return 1/0;
		}
		catch(ArithmeticException ex){
			System.out.println("1. Arithmetic exception occoured: " +ex);
			return 0;
		}
	}
}

/**
 * This class is used for throwing various exception
 * 
 */

class Test{
	private int a;

}
