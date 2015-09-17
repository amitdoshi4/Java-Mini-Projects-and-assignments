
import java.util.Scanner;
/**
 * This class takes the input from the user.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/29/2014
 * 
 */
public class Customer {
	
	/**
	 * The main program.
	 *
	 * @param    args    command line arguments (ignored)
	 * @param	 id      The id of the item
	 * @param	 quantity The quantity of the item
	 */
	public static void main(String args[]){
		System.out.println("Please select from the following items that you want to put in the bag:");
		System.out.println("ID.    Name       Cost/piece");
		System.out.println("1      Apple      50 cents");
		System.out.println("2      Flour      70 cents");
		System.out.println("3      Kiwis      70 cents");
		System.out.println("4      Oranges    70 cents");
		System.out.println("5      Milk       33 cents");
		System.out.println("Please enter the total number(less than 100) of items you wish to put in the bag");
		Scanner scanner = new Scanner(System.in);
        int totalItems = scanner.nextInt();
        if(totalItems>5){
       	 System.err.println("!OOPS you can select only 5 quantities");
       	 System.exit(0);
        }        
        int id[] = new int[totalItems];   
        int quantity[] = new int[totalItems];
        int sum = 0;
     for(int i=0; i<totalItems; i++){
    	 System.out.println("Enter the item ID");
        	id[i] = scanner.nextInt();
         System.out.println("Enter the quantity");
        	quantity[i] = scanner.nextInt();
        	sum = sum+quantity[i];
    }
  		Item it = new Item();
  	     if(sum>100)
  	    	 System.err.println("!OOPS total item exceeded 100");
  	     else
		     it.items(id, quantity);
				
	}

}
