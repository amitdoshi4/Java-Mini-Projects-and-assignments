/**
 * This class calculates the bill
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/29/2014
 * 
 */
public class Cashier {
	/**
	 * Calculate the bill
	 * @param i int used in the for loop 
	 * @param item The item in the bag
	 * @param quantity The quantity of the item
	 * @param price Price of the item
	 * @param total the total cost
	 * @return  void
	 */		
	public void calculateBill(int quantity[], int price[], String item[]){
		float total = 0;
		for(int i=0; i<price.length; i++){
			total = total + quantity[i]*price[i];
		}
		total = total/100;
		Receipt r = new Receipt();
		r.printReceipt(item, quantity, price, total);
	}

}
