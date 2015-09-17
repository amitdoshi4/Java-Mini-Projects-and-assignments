      public class  X {
        static int x1 = 0;
        int o1 = 1;

        public X()    {
        }
        static public void methodX1(int i){
              x1 = i;
              System.out.println("methodX1: " + x1 );
        }
        public void methodX2(int i){
              x1 = i;
              o1 = i;
              System.out.println("methodX2: " + this);
              System.out.println("    x1 " + x1);
              System.out.println("    o1 " + o1);
        }

        public static void main(String args[] )       {
              X aX = new X();
              X aaX = new X();

              aX.methodX1(1);
              aaX.methodX1(2);

              aX.methodX2(3);
              aaX.methodX2(4);
        }
}