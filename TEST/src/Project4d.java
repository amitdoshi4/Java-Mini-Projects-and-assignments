/**
 * 
 * @author Amit Doshi
 *
 *This class calculates the minimum sum of extra spaces using dynamic programming and then prints the paraghraph by storing the optimal choices in the choices array
 */
 
public class Project4d 
{
	static boolean [][]choices;  //global choices array
	/**
	 * This function calculates the minimum cost per line and store is in cost array
	 * @param S the sequence
	 * @param M capacity of the line
	 * @return  the boolean array of choices
	 */
    public static boolean[][] extra2(String S, int M)
    {
    	String strs[] = S.split(" ");
        int[][] cost = new int[strs.length][M];
        boolean[][] path = new boolean[strs.length][M];
         
        for (int i = strs.length - 2; i >= 0; i--)
        {
            int l = strs[i].length();
            for (int j = 0; j <= M - l; j++)
            {
                path[i][j] = true;
                cost[i][j] = cost[i+1][0] + M - (j + l);
                if (1 + strs[i+1].length() + j + l <= M)
                {
                    int tmp = cost[i+1][j+1+l];
                    if (tmp < cost[i][j])
                    {
                        cost[i][j] = tmp;
                        path[i][j] = false;
                    }
                }
            }
        }
        
        choices = path;
         
    printParagraph(S,M);
         System.out.println();
        System.out.println("The total minimum extra space used is : " + cost[0][0]);
        return choices;
    }
    /**
     * This method prints the paragraph using the boolean array choices
     * @param S
     * @param M
     */
    public static void printParagraph(String S , int M){
    	 String strs[] = S.split(" ");
         System.out.print(strs[0]);
         int col = 0;
         for (int i = 0; i < strs.length-1; i++)
         {
             if (choices[i][col])
             {
                 System.out.println("");
                 col = 0;
                 System.out.print(strs[i+1]);
             }
             else
             {
                 System.out.print(" ");
                 System.out.print(strs[i+1]);
                 col += (1 + strs[i].length());
             }
         }
     }
     /**
      * Test
      * @param arg
      */
    static public void main(String[] arg)
    {
        String s = "My name is Amit Doshi and I study at Rochester institute of technology";  
                
         
        extra2(s, 12);
    }
}