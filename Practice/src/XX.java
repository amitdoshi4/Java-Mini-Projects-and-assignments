//import test.X;
public class  XX  extends X {

        static int staticX = 5;
        int instanceX = 0;

        public XX(int i)    {
		staticX   = i;
		instanceX = i * 2;
        }
        public String  toString(){
		return "X: staticX/instanceX = " + staticX + "/" + instanceX;
  	}
        static public void sMethod(int i){
		System.out.println("child");
	}
        public static void iMethod(int i){
 System.out.println("child");
        }
        public void iMethodX(int i){
		staticX   += i;
		instanceX += i * 2;
		System.out.println("child" + staticX);
        }
        public void iMethodXX(int i){
		staticX   += i;
		instanceX += i * 2;
        }
        public static void main(String args[] )       {
		//X   aX1 = new X(1);
		//X   aX2 = new XX(2);
		//XX aXX1 = new XX(3);
			
		//aX2.iMethodX(2);
		//aX2.iMethod(3);
        	X x1 = new X();
        	System.out.println(x1.toString());
		
        }
}