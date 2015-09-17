/**
 * This class calculates the number of kings that can be placed in the given chess board.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 08/31/2014
 * 
 */



public class BoardQueen {
	
	static int board [][] = new int[8][8]; //chess borad matrix
	static int[] h; // horizontal moves
	static int[] v; // vertical moves
	
	static int numberOfKings = 0;  //number of kings
	static int chessBoardSquare = 1;  //chess board square
	
	 /**
	   * The main program.
	   *
	   * @param    args    command line arguments (ignored)
	   */
	public static void main(String[] args) {

		h = new int[4];
		v = new int[4];
		// up right
		h[0] = -1;
		v[0] = 1;
		// down left
		h[1] = 1;
		v[1] = -1;
		// up left
		h[2] = -1;
		v[2] = -1;
		// down right
		h[3] = 1;
		v[3] = 1;
			numberOfWays();//calling the method to calculate the number of ways.
			int i,j;
			for(i=0;i<8;i++)
		    {
		           for(j=0;j<8;j++)
		        {
						System.out.print(board[i][j]+" ");
		            
		        }
		           System.out.println();
		    }
			System.out.println();
			System.out.println("The maximum number of new Kings that can be placed are: " + numberOfKings);//displaying the total ways
					
	}
	/**
     * Returns the number of kings that can be placed
     * @param 
     * @return  numberOfKings total number of kings
     */
		
	private static int numberOfWays() {

		for(int row =0; row<8; row++){			
			for(int col =0; col<8;col++){
				if(!isAttacked(row,col)){   //calling the boolean methods isAttacked and isWhite 
					board[row][col] = 1;
					numberOfKings++;					
				}				
			}
		}
		chessBoardSquare++;
		//if(chessBoardSquare<80)
			//return numberOfWays(); //recursive call
				
		return numberOfKings;  //return the total number of kings
		
	}
	
	/**
     * Returns true if the king is under attack else returns false
     * @param row the integer row
     * @param col the integer column
     * @return  boolean true/false
     */
	
	static boolean isAttacked(int row, int col){
		boolean isAttacked = false;
		

			int t_row_s = 0, t_col_s = 0, t_row_l = 7, t_col_l = 7;

			boolean condition = false;

			// Wall Conditions for rows & columns
			if (row == 0) {
				if (col <= 5)
					t_col_l = 5;
				else {
					t_col_s = 6;
					t_col_l = 7;
				}
			} else if (row == 1) {
				if (col <= 3)
					t_col_l = 3;
				else if (col <= 5) {
					t_col_s = 4;
					t_col_l = 5;
				} else {
					t_col_s = 6;
					t_col_l = 7;
				}
			} else if (row == 2) {
				if (col <= 3)
					t_col_l = 3;
				else {
					t_col_s = 4;
					t_col_l = 7;
				}
			} else if (row == 3) {
				if (col <= 4)
					t_col_l = 4;
				else {
					t_col_s = 5;
					t_col_l = 7;
				}
			} else if (row == 4) {
				if (col <= 1)
					t_col_l = 1;
				else if (col <= 4) {
					t_col_s = 2;
					t_col_l = 4;
				} else {
					t_col_s = 5;
					t_col_l = 7;
				}
			} else if (row == 5) {
				if (col <= 1)
					t_col_l = 1;
				else {
					t_col_s = 2;
					t_col_l = 7;
				}
			} else if (row == 6) {
				if (col <= 5)
					t_col_l = 5;
				else {
					t_col_s = 6;
					t_col_l = 7;
				}
			} else if (row == 7) {
				if (col == 0) {
					t_col_l = 0;
				} else if (col <= 5) {
					t_col_s = 1;
					t_col_l = 5;
				} else {
					t_col_s = 6;
					t_col_l = 7;
				}
			}

			if (col == 0) {
				if (row <= 1)
					t_row_l = 1;
				else if (row <= 6) {
					t_row_s = 2;
					t_row_l = 6;
				} else {
					t_row_s = 7;
					t_row_l = 7;
				}
			} else if (col == 1) {
				if (row <= 1)
					t_row_l = 1;
				else {
					t_row_s = 2;
					t_row_l = 7;
				}
			} else if (col == 2) {
				if (row <= 1)
					t_row_l = 1;
				else if (row <= 5) {
					t_row_s = 2;
					t_row_l = 5;
				} else {
					t_row_s = 6;
					t_row_l = 7;
				}
			} else if (col == 3) {
				if (row <= 2)
					t_row_l = 2;
				else if (row <= 5) {
					t_row_s = 3;
					t_row_l = 5;
				} else {
					t_row_s = 6;
					t_row_l = 7;
				}
			} else if (col == 4) {
				if (row <= 2)
					t_row_l = 2;
				else if (row <= 5) {
					t_row_s = 3;
					t_row_l = 5;
				} else {
					t_row_s = 6;
					t_row_l = 7;
				}
			} else if (col == 5) {
				if (row <= 2)
					t_row_l = 2;
				else if (row <= 4) {
					t_row_s = 3;
					t_row_l = 4;
				} else {
					t_row_s = 5;
					t_row_l = 7;
				}
			} else if (col == 6) {
				if (row <= 4) {
					t_row_l = 4;
				} else {
					t_row_s = 5;
					t_row_l = 7;
				}
			} else if (col == 7) {
				if (row <= 4) {
					t_row_l = 4;
				} else {
					t_row_s = 5;
					t_row_l = 7;
				}
			}	
			
		/*for (int column = t_col_s; column <= t_col_l; column++){
		if(board[row][column]==1)
			return true;
		}
		for (int row_ = t_row_s; row_ <= t_row_l; row_++){
		  if(board[row_][col]==1)
			return true;
		}
		
		for (int row_ = row, col_ = col; row_ >= t_row_s && col_ <= t_col_l; row_--, col_--){
		if(row_>0&&col_>0&&board[row_][col_]==1)
			return true;
		}
		
		for (int row_ = row, col_ = col; row_ <= t_row_l && col_ >= t_col_s; row_++, col_--){
			if(row_<8&&col_>0&&board[row_][col_]==1)
				return true;
		}
		for (int row_ = row, col_ = col; row_ >= t_row_s && col_ >= t_col_s; row_--, col--) {
			if(row_>0&&col_>0&&board[row_][col_]==1)
				return true;
		}
		for (int row_ = row, col_ = col; row_ <= t_row_l && col_ <= t_col_l; row_++, col_++){
			if(row_<8&&col_<8&&board[row_][col_]==1)
		return true;
		}	*/
			for (int column = t_col_s; column <= t_col_l; column++){
				if(board[row][column]==1)
					return true;
				}
				for (int row_ = t_row_s; row_ <= t_row_l; row_++){
				  if(board[row_][col]==1)
					return true;
				}
			for (int row_ = row, col_ = col; row_ >= t_row_s && col_ <= t_col_l; row_ += h[0], col_ += v[0]) {
				if (board[row_][col_] == 1) {
					isAttacked =  true;
				}
			}
			for (int row_ = row, col_ = col; row_ <= t_row_l && col_ >= t_col_s; row_ += h[1], col_ += v[1]) {
				if (board[row_][col_] == 1) {
					isAttacked =  true;
				}
			}
			for (int row_ = row, col_ = col; row_ >= t_row_s && col_ >= t_col_s; row_ += h[2], col_ += v[2]) {
				if (board[row_][col_] == 1) {
					isAttacked =  true;
				}
			}
			for (int row_ = row, col_ = col; row_ <= t_row_l && col_ <= t_col_l; row_ += h[3], col_ += v[3]) {
				if (board[row_][col_] == 1) {
					isAttacked =  true;
				}
	
	}
			return isAttacked;
  }
}
	
	/**
     * Returns true if the square is white else returns false
     * @param row the integer row
     * @param col the integer column
     * @return  boolean true/false
     */

	



