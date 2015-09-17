public class Evaluator extends Thread {
	public void run(){
                System.out.println("---->");
                System.out.println("---->");
                System.out.println("---->");
                System.out.println("---->");
             try { sleep(100); } catch (  InterruptedException e ) { }
                System.out.println("<----");
                System.out.println("<----");
                System.out.println("<----");
                System.out.println("<----");
        }
	public static void multiply(){
		for(int i = 0; i < 3; i++){
			for(int j =0; j < 10; j++){
				// Evaluator et = new Evaluator();
				Thread et = new Evaluator();
				et.start();

				try{
					et.join();
					System.out.println("here");
				}
				catch(InterruptedException e){
					System.out.println("Interrupted!");
				}

			}
		}
	}
	public static void main(String[] args) {
		Evaluator eval = new Evaluator();
		eval.multiply();
		
	}
}