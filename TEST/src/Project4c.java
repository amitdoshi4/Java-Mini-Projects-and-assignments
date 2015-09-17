/**
 * 
 * @author Amit Doshi
 * 
 * This class calcualtes the extraSpace cost for all the line except the last line using dynamic programming
 *
 */
public class Project4c {
	/**
	 * This function calculates the minimum cost per line and store is in cost array
	 * @param S the sequence
	 * @param M capacity of the line
	 * @return  
	 */
	public static void extra2(String S, int M)
    {
    	String strs[] = S.split(" ");
        int[][] cost = new int[strs.length][M];
         
        for (int i = strs.length - 2; i >= 0; i--)
        {
            int l = strs[i].length();
            for (int j = 0; j <= M - l; j++)
            {
                cost[i][j] = cost[i+1][0] + M - (j + l);
                if (1 + strs[i+1].length() + j + l <= M)
                {
                    int tmp = cost[i+1][j+1+l];
                    if (tmp < cost[i][j])
                    {
                        cost[i][j] = tmp;
                    }
                }
            }
        }

         
        System.out.println("The total minimum extra space used is : " + cost[0][0]);
    }
/**
 * Test function
 * @param arg
 */
    static public void main(String[] arg)
    {
        String s = "My name is Amit Doshi and I study at Rochester institute of technology";  
                
         
        extra2(s, 22);
    }

}
