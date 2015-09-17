import java.util.Scanner;
/**
 * This class moves the tower of hanoi problem by recursion.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/23/2014
 * 
 */

public class Hanoi {
	//The number of disks
	static int numberOfDisks;
	//declaring 3 arrays for the 3 towers
	static int a[] ;
	static int b[] ;
	static int c[] ;

	/**
     * Place the disks in the towers
     * @param n int   The total number of disks
     * @param poleStart String  Starting pole
     * @param poleOver  String  Over pole
     * @param poleEnd   String  End pole
     * @return  void
     */	
   public static void move(int n, String poleStart, String poleOver, String poleEnd) {
       if (n == 1) {
           System.out.println("Move Disk " + n + " from " + poleStart + " to " + poleEnd );
           printHanoi(n,poleStart, poleOver, poleEnd);
       } else {
           move(n - 1, poleStart, poleEnd, poleOver);
           System.out.println("Move Disk " + n + " from " + poleStart + " to " + poleEnd);
           printHanoi(n,poleStart, poleOver, poleEnd);
           move(n - 1, poleOver, poleStart, poleEnd) ;
       }
   }

	/**
    * Print the towers state each time a disk is moved
    * @param n int   The total number of disks
    * @param poleStart String  Starting pole
    * @param poleOver  String  Over pole
    * @param poleEnd   String  End pole
    * @return  void
    */
private static void printHanoi(int n, String poleStart, String poleOver, String poleEnd) {
	for(int i=numberOfDisks-1;i>=0;i--){
	if(poleEnd.equals("B")&&b[i]==0){
		b[i]=n;	
		break;
	}
	else if(poleEnd.equals("C")&&c[i]==0){
			c[i]=n;	
		break;
		}
	else if(poleEnd.equals("A")&&a[i]==0){
		a[i]=n;	
		break;
	   }
	}	
	 for(int i =0; i<numberOfDisks;i++){
		 if(a[i]==n&&poleStart.equals("A"))
			 a[i]=0;
	 }
	 for(int i =0; i<numberOfDisks;i++){
		 if(b[i]==n&&poleStart.equals("B"))
			 b[i]=0;
	 }
	 for(int i =0; i<numberOfDisks;i++){
		 if(c[i]==n&&poleStart.equals("C"))
			 c[i]=0;
	 }
	   for(int i =0; i<numberOfDisks;i++){
			System.out.print(a[i]);
			System.out.print(b[i]);
			System.out.print(c[i]);
			System.out.println();
		}	   	
		System.out.println("---");
		System.out.println("ABC");
 }

/**
 * The main program.
 *
 * @param    args    command line arguments (ignored)
 */
public static void main(String[] args) {
       System.out.print("Enter number of discs: ");
       Scanner scanner = new Scanner(System.in);
       numberOfDisks = scanner.nextInt();
       a = new int[numberOfDisks];
       b = new int[numberOfDisks];
       c = new int[numberOfDisks];
       intitialize();
       move(numberOfDisks, "A", "B", "C");
       scanner.close();
   }

/**
 * initialize the towers
 * @param i int used in the for loop 
 * @param numberOfDisks It is a static variable and it is initialize by the input
 * @return  void
 */
private static void intitialize() {
	for(int i =0; i<numberOfDisks;i++)
		a[i]=i+1;
	for(int i =0; i<numberOfDisks;i++){
		b[i] = 0;
		c[i]=0;
	}
	for(int i =0; i<numberOfDisks;i++){
		System.out.print(a[i]);
		System.out.print(b[i]);
		System.out.print(c[i]);
		System.out.println();
	}	   	
	System.out.println("---");
	System.out.println("ABC");
  }
}