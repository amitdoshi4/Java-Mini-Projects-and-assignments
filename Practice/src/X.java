public class  X {
        static int staticX = 0;
        int instanceX = 0;

       public X()    {	
        	System.out.println("here");// why is this one needed?
        }
        public X(int i)    {
        	System.out.println("here");
		staticX   = i;
		instanceX = i * 2;
        }
        public String  toString(){
		return "X: staticX/instanceX = " + staticX ;
  	}
        static public void sMethod(int i){
		staticX   += i;
	}
        public static void iMethod(int i){
		System.out.println("parent");
        }
        public void iMethodX(int i){
		staticX   += i;
		instanceX += i * 2;
		
        }
        public static void main(String args[] )       {
        	System.out.println("abcde".compareTo("abcd"));
        }
}