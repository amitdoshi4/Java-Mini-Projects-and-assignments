package test;
import java.util.Scanner;

public class Customer {
	
	
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
        System.out.println("Enter the ID and quantity:");
        int id[] = new int[totalItems];
        int quantity[] = new int[totalItems];
        int sum = 0;
     for(int i=0; i<totalItems; i++){
        	id[i] = scanner.nextInt();
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
