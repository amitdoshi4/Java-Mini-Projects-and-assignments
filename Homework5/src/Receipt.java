
/**
 * This class prints the receipt 
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/29/2014
 * 
 */
public class Receipt {
	/**
	 * Print the receipt
	 * @param i int used in the for loop 
	 * @param item The item in the bag
	 * @param quantity The quantity of the item
	 * @param price Price of the item
	 * @param total the total cost
	 * @return  void
	 */		
	public void printReceipt(String item[], int quantity[], int price[], float total){
		System.out.println(" *** Receipt ***   ");
		System.out.println("Item  Quantity  Price");
		for(int i=0; i<price.length; i++){
			System.out.println(item[i]+"\t"+quantity[i]+"\t("+price[i]+")");					
		}

		System.out.println("--------------------------");
		System.out.println("Total: $"+ total);
	}

}
