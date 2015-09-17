import java.util.Scanner;

/**
 * This class puts the item in the bag.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/29/2014
 * 
 */
public class Bag {

	/**
	 * initialize an print the bag
	 * @param i int used in the for loop 
	 * @param item The item in the bag
	 * @return  void
	 */	
	void printBag(String item[], int quantity[]){
		System.out.println("The Following items are in the bag");
		for(int i =0; i<item.length;i++){
			System.out.println(item[i]+"\t"+ quantity[i]);
		}
		System.out.println("Do you want to proceed?");
		System.out.println("Press '1' to continue or '0' to exit");
		Scanner scanner = new Scanner(System.in);
        int cont = scanner.nextInt();
        if(cont==0){
        	System.err.println("!BYE BYE");
        	System.exit(1);
        }
	}
}
