package test;

public class Receipt {
	
	public void printReceipt(String item[], int quantity[], int price[], float total){
		System.out.println(" *** Receipt ***   ");
		System.out.println("Item  Quantity  Price");
		for(int i=0; i<price.length; i++){
			System.out.println(item[i]+" \t"+quantity[i]+" \t("+price[i]+")");					
		}

		System.out.println("--------------------------");
		System.out.println("Total: $"+ total);
	}

}
