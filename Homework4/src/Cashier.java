package test;

public class Cashier {
	
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
