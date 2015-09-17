import java.util.ArrayList;


public class PrintNeatly {
	static ArrayList<Integer> C = new ArrayList<Integer>();

	public static int extraRec(String S1, int M, int i){
		String [] S = S1.split(" ");
		int j = i;
		int k =0;
		int c =0;
		int temp =1;
		int temp2 =0;
		int extraSpace=0;
		int totalExtra =0;
			if(S[i].length()>M)
				return 9999; //infinite
			else {
				while(j<S.length && c<=M){
					
			if(j== i&& c+S[j].length()<=M){
                 c= c+S[j].length();
                 temp =c;
				}
			else if(temp+S[j].length()+1<=M){
				 c= c+S[j].length();
				 temp = temp+S[j].length()+1;
				 k++;
					}
					
			else break;

				 j++;			 
				}
               
				extraSpace= M-(j-1)+i-c;
				if(j!=S.length)
				C.add(extraSpace);
				
			
		}
			if(j==S.length){
			for(Integer value: C){
				System.out.println("The minimum extra space used at line " + temp +"= "+ value);
				temp++;
				totalExtra = totalExtra + value;
			}
			System.out.println("Total extra space except the last line = " + totalExtra);
			}
			if(j<S.length)
				extraRec(S1,M,j);
			return j;
	}
	public static void main(String args[]){
		String s = "I think Introduction to algorithm is hard but very worth reading you will learn a lot";
		extraRec(s,22,0);
	}
}
