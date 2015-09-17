import java.util.Arrays;


public class ProducerConsumer {
static int[] numberOfScrews = new int[0];
static int[] numberOfStand = new int[0];

public synchronized void addScrews(){
	while(numberOfScrews.length>=10)
	{
		try {
			System.out.println("Producer in wait for screws");
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch bock
			e.printStackTrace();
		}
	}
	System.out.println("Producer done with Screws");
	numberOfScrews=Arrays.copyOf(numberOfScrews, numberOfScrews.length+4);
	
	notifyAll();
}
public synchronized void addStand(){
	while(numberOfStand.length>=10)
	{
		try {
			System.out.println("Producer in wait for stand");
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch bock
			e.printStackTrace();
		}
	}
	System.out.println("Producer done with stand");
	numberOfStand=Arrays.copyOf(numberOfStand, numberOfStand.length+4);
	
	notifyAll();
}

public synchronized void delete(Consumer c){
	while(numberOfScrews.length<2||numberOfStand.length<1)
	{
		try {
			System.out.println("Consumer in wait-" + c.info);
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	System.out.println("number of stand available:" + numberOfStand.length);
	System.out.println("number of screws available:" + numberOfScrews.length);
	numberOfScrews=Arrays.copyOf(numberOfScrews, numberOfScrews.length-2);
	numberOfStand=Arrays.copyOf(numberOfStand, numberOfStand.length-1);
	System.out.println("Consumer done-" + c.info);
	notifyAll();
}

public static void main(String args[]){
	ProducerConsumer p = new ProducerConsumer();
	Producer prodScrew = new Producer(p,"Screws");
	Producer prodStand = new Producer(p,"Stand");
	Consumer con = new Consumer(p, "first");
	Consumer con2 = new Consumer(p, "second");
	prodScrew.start();
	prodStand.start();
	con.start();
	con2.start();
}
}