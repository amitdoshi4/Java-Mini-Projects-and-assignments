/**
 * This class is a thread implementation to print a sequence of 'abcabc..'
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 11/10/2014
 * 
 */
public class MyThread extends Thread	{
	private String info;
	static Object o = new Object();
	 static int semaphore =0;

/**
* Constructor
* @param String info 
*/		 
	public MyThread (String info) {
		this.info  = info;
	}

/**
* run method for the thread
* @param null
* @return void
*/	
	public void run () {
		while(true){
	synchronized(o){
		if(this.info=="a")
		firstThread();
		if(this.info=="b")
		secondThread();
		if(this.info=="c")
		ThirdThread();
	}
		}
		
	}
	
/**
* Method for the third thread
* @param null
* @return void
*/	
	private void ThirdThread() {
			 {								
					try {
						sleep(5);
						if(semaphore==2){
							System.out.print(this.info);
							 semaphore=0;
							o.notifyAll();
							o.wait();
						}
						
					} catch ( Exception e ) { }
			}	
			}
/**
* Method for the second thread
* @param null
* @return void
*/			
	private void secondThread() {			
					try {
						sleep(5);
						if(semaphore==1){
						o.notifyAll();						
						System.out.print(this.info);
						semaphore++;
						o.wait();
						}
						
					} catch ( Exception e ) { }
			}	
			
/**
* Method for the first thread
* @param null
* @return void
*/			
	private void firstThread() {
					try {
						sleep(5);
						if(semaphore==0){
							System.out.print(this.info);
							o.notifyAll();
							semaphore++;
							o.wait();
						}
					} catch ( Exception e ) { }
			}	
		
/**
 * The main program.
 *
 * @param    args    command line arguments (ignored)
 */
	public static void main (String args []) {
	  MyThread t1 = new MyThread("a");
	  MyThread t2 = new MyThread("b");
	  MyThread t3 = new MyThread("c");
      t1.start();
      t2.start();
      t3.start();
	}
}