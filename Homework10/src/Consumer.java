import java.util.Random;


public class Consumer extends Thread{
	public ProducerConsumer p;
	String info;
	public Consumer(ProducerConsumer p, String info){
		this.p=p;
		this.info=info;
	}
	
	public void run(){
		try {
			Random r = new Random();
			sleep(r.nextInt(5000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		p.delete(this);
	}

}
