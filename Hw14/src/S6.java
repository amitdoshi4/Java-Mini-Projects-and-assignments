public class S6 extends S5 {

  public int instanceV = 6;		
  public static int staticV = 12;

  public S6(int q){
	  
  }
  public S6(){
	  
  }
  public void both()	{
	instanceV = 100;
  }
  public String toString()      {
        return "S6: " + staticV;
  }
  public void Func(){
	  System.out.println("child");
  }
  public int superA()      {
	  return super.instanceV;
  }


  public static void main(String args[]) {
 	S6 aS6 = new S6(1);
	S5 aS5 = (S5)aS6;
	S5 as = new S6();
	
	System.out.println("1. aS6 =" + as );
	System.out.println("2. aS5 =" + aS5 );

	aS6.both();
	System.out.println("3. aS6 =" + as );
	System.out.println("4. aS5 =" + aS5 );

	aS5.both();
	
	System.out.println("5. aS6 =" + as );
	System.out.println("6. aS5 =" + aS5 );

	System.out.println("7. aS6.superA(): " + aS6.superA());
	System.out.println("---" + aS5.staticV);

  }
}
