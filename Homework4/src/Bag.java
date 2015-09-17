package test;

public class Bag {

	void printBag(String item[], int quantity[]){
		System.out.println("The Following items are in the bag");
		for(int i =0; i<item.length;i++){
			System.out.println(item[i]+"\t"+ quantity[i]);
		}
	}
}
