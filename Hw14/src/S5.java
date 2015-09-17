public class S5 {

  public int instanceV = 1;		
  public static int staticV = 2;
  
  public S5(int h){
	  
  }

  public String toString()	{
	return "S5: " + staticV;
  }
  public void both()    {
        instanceV = 200;
  }
  public static void main(String args[]) {
	System.out.println(new S5(2));
  }
}
