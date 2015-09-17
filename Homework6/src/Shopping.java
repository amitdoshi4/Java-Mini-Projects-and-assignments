/**
 * This class is the interface for the shopping cart simulator.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 10/05/2014
 * 
 */
public interface Shopping {
	int a=5;
	/**
	* Add the prices of the items
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	 void items(int start, int id[], int quantity[], int totalItems);
	/**
	* Print the bag
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	public void printBag(int start, String item[], int quantity[], int totalItems);
	/**
	* Add the prices of the items
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	public void printReceipt(int start, String item[], int quantity[], int price[], float total, int totalItems);
	/**
	* Calculate the bill
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	public void calculateBill(int start, int quantity[], int price[], String item[], int totalItems);
}
