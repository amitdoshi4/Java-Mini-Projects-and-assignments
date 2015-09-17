public class abc extends Thread {

		private String info;
		static Object lock1 = new Object();
		static int count;

		public abc() {
			// TODO Auto-generated constructor stub
			this.info = "1";
		}

		public abc(String info) {
			this.info = info;
		}

		public void run() {
			while (true) {
				
				synchronized (lock1) {
					
					System.out.print(info);//+ "in Block 1");
					lock1.notifyAll();
					try {
						sleep(1000);
						if(count == 0){
							count++;
							new abc("b").start();
						}
						lock1.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				
				synchronized (lock1) {
					//System.out.println("Thread "+ info +" in Block 2");
					if(count == 1){
						count++;
						new abc("c").start();
					}
					if(count != 2)
						lock1.notify();
					count++;
					try {
						lock1.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
	
			}
		}

		public static void main(String[] args) throws InterruptedException {
			new abc("a").start();

		}

	}