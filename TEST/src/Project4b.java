import java.util.ArrayList;

/**
 * 
 * @author Amit Doshi
 * 
 * This class calcualtes the extraSpace cost for all the line except the last line using recursion
 *
 */
public class Project4b {
	static ArrayList<Integer> C = new ArrayList<Integer>();
/**
 * 
 * @param Sequence - the string
 * @param M-  the capacity of a line
 * @param i- slicing index
 * @return
 */
	public static int extraRec(String Sequence, int M, int i){
		String [] S = Sequence.split(" ");
		int j = i;
		int c =0;
		int temp =1;
		int extraSpace=0;
		int totalExtra =0;
			if(S[i].length()>M) // if the word length is greater than the capacity of line
				return 9999; //infinite
			else {
				while(j<S.length && c<=M){  // the main loop for the calculation
					
			if(j== i&& c+S[j].length()<=M){
                 c= c+S[j].length();
                 temp =c;
				}
			else if(temp+S[j].length()+1<=M){
				 c= c+S[j].length();
				 temp = temp+S[j].length()+1;
					}
					
			else break;  //break if the line is full

				 j++;			 
				}
               
				extraSpace= M-(j-1)+i-c;   // M-j+i-sum of length of words
				if(j!=S.length)
				C.add(extraSpace);         // add to the arrayList
				
			
		}
			if(j==S.length){    //logic for printing
			for(Integer value: C){
				System.out.println("The minimum extra space used at line " + temp +"= "+ value);
				temp++;
				totalExtra = totalExtra + value;
			}
			System.out.println("Total extra space except the last line = " + totalExtra);
			}
			if(j<S.length)
				extraRec(Sequence,M,j);   //recursion
			return j;
	}
	/**
	 * Test 
	 * @param args
	 */
	public static void main(String args[]){
		String s = "My name is Amit Doshi and I study at Rochester institute of technology";
		extraRec(s,12,0);
	}
}
