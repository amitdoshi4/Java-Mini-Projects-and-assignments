
public class  XX extends X {
        static int x1 = 0;
        int o1 = 1;

        public XX()    {
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
              X aXX = new XX();

              aX.methodX1(1);
              aXX.methodX1(2);

              aX.methodX2(3);
              aXX.methodX2(4);

	      aX = (aXX);
              aX.methodX2(3);
              aX.methodX2(4);

	      
        }
}