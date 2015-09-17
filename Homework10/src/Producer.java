import java.util.Random;


public class Producer extends Thread{
	public ProducerConsumer p;
	String whichOne;
	public Producer(ProducerConsumer p, String whichOne){
		this.p=p;
		this.whichOne=whichOne;
	}

	public void run(){
		try {
			Random r = new Random();
		    sleep(r.nextInt(5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		if(this.whichOne.equals("Screws"))
		p.addScrews();
		else
			p.addStand();
	}
}
