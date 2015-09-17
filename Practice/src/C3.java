class C3 extends C1  implements  I4 {
	public static void main(String args[])	{
		C1 aC1 = new C1();
		C2 aC2 = new C2();
		C3 aC3 = new C3();
		I1 aI1 = null; I2 aI2 = null; I3 aI3 = null;
		aC1 = (C1)aC3;		// 1
		aI1 = (I1)aC3;		// 2
		aI1 = (I1)aC2;		// 3
		aI2 = (I2)aC3;		// 4
		//aI1 = (aI1)aI2;		// 5
		aI2  = (I2)aI3;		// 6
		
	}
}