/**
 * This class is the abstract class for the shopping cart simulator.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 10/05/2014
 * 
 */
public abstract class ShoppingAbstract {
	int a;
	/** Abstract method
	* Add the prices of the items
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	public abstract void items(int start, int id[], int quantity[], int totalItems);
	/**Abstract method
	* Print the bag
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	public abstract void printBag(int start, String item[], int quantity[], int totalItems);
	/**Abstract method
	* Add the prices of the items
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	public abstract void printReceipt(int start, String item[], int quantity[], int price[], float total, int totalItems);
	/**Abstract method
	* Calculate the bill
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	public abstract void calculateBill(int start, int quantity[], int price[], String item[], int totalItems);
}
