public class S6   {
	public String toString()	{
		return "S6";
	}

  public static void main(String[] args) {				// 1
	S6 aS6 = new S6();
	// 2
	S5 aS5 = (S5)aS6;					// 3
		System.out.println("1:	" + aS5);	// 4
				// 11
		System.out.println("4:	" + aS5);	// 11
	
  }
}