package homework_2;

class FlowC
{
   int[] numbers = { 3, 5, 6, 1, 0, -1, 22, 14, 5, 9, 0, 1, -1 };

   static boolean trueIfZero(double n) {
	return n == 0.0;
   }
   static boolean greaterZero(double n) {
	return n > 0.0;
   }
   static double aDividedByN(double a, double b)      {
	return a / b;
   }

   static int test_1(int n)	{
	if ( ++n == 1 )
		return 1;
	else if ( n-- == 1 )
		return 2;
	else if ( --n == 0 )
		return 3;
	else
		return 4;
   }
   static int test_2(int n)	{
        n = -1;
	while ( n < 4 )	{
		if ( n-- == -1 )
			n = 1;
		if ( ( n + 1 ) % 2 == 0 )
			n = 2;
		else if ( n == 3 )
			n = n++;
		n = n + n;
	}
	if ( ( n = 1 ) == 1 )
		n = 3;
	return n;
   }
   static int test_3(int a, int b)	{
	return a<b?a:b;							// change made by using ?: statement
   }
   static double test_4(double a, double b)	{
	if  (trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) | trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) || trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) & trueIfZero(a) )
		return aDividedByN(b , a );
	if  (greaterZero(a) && trueIfZero(a) )
		return aDividedByN(b , a );
	if  (! greaterZero(a) && ! trueIfZero(a) )
		return aDividedByN(b , a );
	if  ( greaterZero((int)a >>1 ) && trueIfZero(a) )
		return aDividedByN(b , a );
	if  ( greaterZero((int)a >>>1 ) && trueIfZero(a) )
		return aDividedByN(b , a );
	return 12;                          // change made to avoid compilation error "method must return a value of type double"
   }


   public static void main(String args[])
   {  
	   int g[]={9,89,7,5,4,3,2};
	   int min;
	// a) create 4 statements so such test_1 returns all possible values
	  System.out.println("a:	test_1(0):	" + test_1(0) ); //returns 1
	   System.out.println("a:	test_1(0):	" + test_1(1) ); //returns 3
	   System.out.println("a:	test_1(0):	" + test_1(2) ); //returns 4
	// is it possible to get all 4 possible values?
	   /* No.
	    * It is not possible to get all the 4 values that is because on passing
	    * any value to test_1() it will never return 2.
	    * This is because 2 will be returned only if value of n is =1 when it is
	    * about to enter the first else if() condition, which is not achievable 
	    * if we pass 0 the first if increments it to 1 and returns 1 and exits the 
	    * if conditions.
	    */
	// System.out.println("a:	test_1(0):	" + test_1(i) );

	// b) explain the execution of test_2
	System.out.println("b:	test_2(2):	" + test_2(100) );
    // in the method test_2() the value 100 gets passed, n=100.
	// In the very first statement the value of n is now set to -1.
	// n being less than 4, the while loop is entered, the if statement is true, value of n
	// gets decremented by 1 to n=-2. INside the if{ the value of n is now set to 1.
	// the second if is true as 2%2==0 now value of n=2. it doesnt enter the else if as n!=3.
	//now n=n+n gets executed so the value of n=4. In the last if the value 1 gets assigned to n
	// which is == 1 and value of n=3. in test_2 for any value of n passed to this method, it 
	// will always return value = 3 as the last if statement assigns n to a value and compares it 
	// with the same value and 3 is returned.
	
	
	// c) simplify test_3 by using a ?: statement
	// change made in the code it self , see line no-43
	
	// d) find the minimum of all numbers in number by using one for loop 
		min=g[0];
		for (int i=1;i<7;i++)
			{
				min=min<g[i]?min:g[i];
			}
		System.out.println(min);
		
	// e) test_4 wil not compile, why? Fix it?
		//Answer:- it wont compile as the method should return a variable of type double
		//         if none of the if conditions are satisfied by the input variables.
		//		   This can be fixed by returning a arbitrary value of type double outside the if statements.(see line 62)
	// create a/b pairs, so such all return statements are executed	
	// is it possible to execute all  return statements.
		//answer:- it is not possible to execute all return statements as if any if condition
		//		   is found to be true the return statement in that if condition gets executed and 
		//         the method returns to the line from where it was called. Thus there
		//         is no combination pair of a/b for which all the return statements are executed.
	System.out.println("e:	test_4(2, 2):	" + test_4(0, 2) );

   }
}


