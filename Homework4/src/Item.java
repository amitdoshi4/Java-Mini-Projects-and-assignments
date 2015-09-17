package test;

public class Item {
	
	public void Print(){
		System.out.println("I am here");  
	}
public void items(int id[], int quantity[]){
	int price[]=new int[id.length];
	String item[] = new String[id.length];
	for (int i =0 ; i<id.length; i++){
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
	
	Bag b = new Bag();
	b.printBag(item, quantity);
	Cashier c = new Cashier();
	c.calculateBill(quantity, price, item);
}
}
