public class Bier {
  private int bier;
  
  public Bier()	{
	bier ++;
  }
	
  public void print()	{
	System.out.println("bier  = " + bier  );
  }

  public static void main(String args[])	{
    try {
		//Class c = Class.forName("Bier");
		//Bier b = (Bier) c.newInstance();
    	Class c = Bier.class;
   
		 
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 }
}