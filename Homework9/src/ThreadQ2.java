
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ThreadQ2 extends Thread {
	double x;
	double y;
	static final double limit = 10.0;
	String info;
    static double volume;
    static List<ThreadQ2> aList = new ArrayList<ThreadQ2>();
	DecimalFormat form = new DecimalFormat("#.#####"); 
    ThreadQ2(double x, double y){
	this.x=x;
	this.y=y;
   }
	public static void main(String args[]){
		double x = -1.0;
		double y = -2.0;
		int c=0,t1=0;
		DecimalFormat form = new DecimalFormat("#.####"); 
		while(t1<=limit*2){
			while(c<=limit*4)
			{
				c++;
				ThreadQ2 t = new ThreadQ2(Double.valueOf(form.format(x)),Double.valueOf(form.format(y)));
				y = y+ 1/limit;
				t.start();
				aList.add(t);
			}
			System.out.println("here");
			c=0;
			y=-2.0;
			x =x + 1/limit;
			t1++;
		}
		Iterator<ThreadQ2> it = aList.iterator();
		while(it.hasNext()){
			try {
				 it.next().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			
				System.out.println("Interrupted!" );
			}
		}
		System.out.println("volume" +volume);

	}

	
// calculating for root x
	/*public void run(){
		double a;
		a = Math.sqrt(x)*(x-(x-1/limit));
		area = a+ area;
		
	}*/
	public void run(){
		double v;
		double temp;
		v = (Math.pow(x, 2)+2*y)*(1/limit)*(1/limit);
		temp=(Double.valueOf(form.format(v)));
		volume = temp+volume;
		System.out.println(x+","+y+","+temp);
		
	}
}
