import java.util.Scanner;

/**
 * This class extends the shoppingAbstract class and is a shopping simulator.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 10/05/2014
 * 
 */
public class ShoppingConcrete extends ShoppingAbstract {
    int id[] = new int[100];   
    int quantity[] = new int[100];
    int sum = 0;
	int price[]=new int[100];
	String item[] = new String[100];
	int totalItems = 0;
	
	/**
	 * The main program.
	 *
	 * @param    args    command line arguments (ignored)
	 * @param	 id      The id of the item
	 * @param	 quantity The quantity of the item
	 */
	public static void main(String args[]){
		ShoppingConcrete c = new ShoppingConcrete();
		c.putItems();
	}
	
	/**
	* Put the items
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
    */	
	private void putItems() {
		int inputID;
		System.out.println("Please select from the following items that you want to put in the bag:");
		System.out.println("ID.    Name       Cost/piece");
		System.out.println("1      Apple      50 cents");
		System.out.println("2      Flour      70 cents");
		System.out.println("3      Kiwis      70 cents");
		System.out.println("4      Oranges    70 cents");
		System.out.println("5      Milk       33 cents");
		System.out.println("Please enter the total number(less than 100) of items you wish to put in the bag");
		Scanner scanner = new Scanner(System.in);
        totalItems = scanner.nextInt();     

     for(int i=0; i<totalItems; i++){
    	 System.out.println("Enter the item ID");
   	  inputID = scanner.nextInt();
       	id[i]= inputID;
       	if(inputID>5||inputID<0){
       		System.err.println("Please enter a valid ID");
       		i--;
       	}
       	if(inputID<=5&&inputID>0){
        System.out.println("Enter the quantity");
       	quantity[i] = scanner.nextInt();
       	sum = sum+quantity[i];
       	}
   }	
  	     if(sum>100)
  	    	 System.err.println("!OOPS total item exceeded 100");
  	     else
		    items(0, id, quantity, totalItems);
		
	}
	/**
	* Add the items
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	private void addItem() {
		int inputID ;
		System.out.println("Please select from the following items that you want to add in the bag:");
		System.out.println("ID.    Name       Cost/piece");
		System.out.println("1      Apple      50 cents");
		System.out.println("2      Flour      70 cents");
		System.out.println("3      Kiwis      70 cents");
		System.out.println("4      Oranges    70 cents");
		System.out.println("5      Milk       33 cents");
		System.out.println("Please enter the total number(less than 100) of items you wish to add in the bag");
		Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
     for(int i=totalItems; i<totalItems+temp; i++){
    	 System.out.println("Enter the item ID");
    	  inputID = scanner.nextInt();
        	id[i]= inputID;
        	if(inputID>5||inputID<0){
        		System.err.println("Please enter a valid ID");
        		i--;
        	}
        	if(inputID<=5&&inputID>0){
         System.out.println("Enter the quantity");
        	quantity[i] = scanner.nextInt();
        	sum = sum+quantity[i];
        	}
    }	
        int start = totalItems;
        totalItems = temp+ totalItems;
  	     if(sum>100)
  	    	 System.err.println("!OOPS total item exceeded 100");
  	     else
		    items(start, id, quantity, totalItems);
		
	}

	@Override
	/**
	* Add the prices of the items
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @return  void
	*/	
	public void items(int start,int[] id, int[] quantity, int totalItems) {
		for (int i =start ; i<totalItems; i++){
			 if(id[i]==1){
				 item[i]="Apples";
				 price[i]=50;
			 }
			 if(id[i]==2){
				 item[i]="Flour";
				 price[i]=70;
			 }
			 if(id[i]==3){
				 item[i]="Kiwis";
				 price[i]=70;
			 }
			 if(id[i]==4){
				 item[i]="Oranges";
				 price[i]=70;
			 }
			 if(id[i]==5){
				 item[i]="Milk";
				 price[i]=33;
			 }
		}
		printBag(start, item, quantity, totalItems);		
	}

	@Override
	/**
	* Print the bag
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @param totalItmes The number of itmes
	* @param start The start of loop
	* @return  void
    */			
	public void printBag(int start, String[] item, int[] quantity, int totalItems) {
		System.out.println("The Following items are in the bag");
		for(int i =0; i<totalItems;i++){
			System.out.println(item[i]+"\t"+ quantity[i]);
		}
		System.out.println("------------------");
		System.out.println("Press '1' to proceed for billing, 2 to add items, 3 to drop, 0 to exit");
		Scanner scanner = new Scanner(System.in);
        int cont = scanner.nextInt();
        if(cont==0){
        	System.err.println("!BYE BYE");
        	System.exit(1);
        }
        	else if(cont==2){
        		addItem();
        	}
        	else if(cont==3){
        		dropItems(start,quantity,price,item,totalItems);
        	}
        	else if(cont==1)
        		calculateBill(start,quantity, price, item, totalItems);
        	else
        		System.out.println("Please enter a valid option");
        }
	/**
	* Drop the items
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @param totalItmes The number of itmes
	* @param start The start of loop
	* @return  void
	*/		
	private void dropItems(int start, int[] quantity, int[] price,
			String[] item, int totalItems) {
		System.out.println("Please enter the item Id to drop");
		boolean inBag = false;
		Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
    	
        for(int i =0; i<totalItems;i++){
        	if(id[i]==temp){
        		for(int j=i; j<totalItems;j++){
        		id[j]=id[j+1];	
        		quantity[j]=quantity[j+1];
        		price[j]=price[j+1];
        		}
				totalItems--;
				inBag = true;
			}
			
		}
        if(!inBag)
        	System.err.println("The item is not in the bag");
        items(start, id, quantity, totalItems);
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	* Print the receipt
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @param totalItmes The number of itmes
	* @param start The start of loop
	* @return  void
	*/		
	public void printReceipt(int start, String[] item, int[] quantity, int[] price,float total, int totalItems) {
		System.out.println(" *** Receipt ***   ");
		System.out.println("Item  Quantity  Price");
		for(int i=start; i<totalItems; i++){
			System.out.println(item[i]+"\t"+quantity[i]+"\t("+price[i]+")");					
		}

		System.out.println("--------------------------");
		System.out.println("Total: $"+ total);
	}

	@Override
	/**
	* Calculate the bill
	* @param id The id of the item
	* @param quantity The quantity of the item
	* @param totalItmes The number of itmes
	* @param start The start of loop
	* @return  void
	*/		
	public void calculateBill(int start, int[] quantity, int[] price, String[] item, int totalItems) {
		float total = 0;
		for(int i=0; i<totalItems; i++){
			total = total + quantity[i]*price[i];
		}
		total = total/100;
		printReceipt(0, item, quantity, price, total, totalItems);
	}

}
