/**
 * This class calculates the number of queens that can be placed in the given chess board.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/09/2014
 * 
 */

public class Board {	
	static int numberOfQueens = 0;  
	static int number = 0;//number of queens		
	 /**
	   * The main program.
	   *
	   * @param    args    command line arguments (ignored)
	   */
	public static void main(String[] args) {
		//Logic to check the best combination.
		for(int row =0; row<8; row++){
			for(int col =0; col<8; col++){
				number = numberOfWays(row,col);
				if(number>numberOfQueens)
					numberOfQueens=number;				
			}
		}
			System.out.println("The maximum number of queens that can be placed are: " + numberOfQueens);//displaying the total ways
					
	}
	/**
     * Returns the number of queens that can be placed
     * @param startRow
     * @param startCol
     * @return  numberOfQueens total number of queens
     */
		
	private static int numberOfWays(int startRow, int startCol) {
		int board [][] = new int[8][8];//creating the chess board		
		int count =0;
		for(int row =startRow; row<8; row++){		//looping for every block	
			for(int col =startCol; col<8;col++){
				if(!isAttacked(row, col, board)){
					board[row][col] = 1;
					count++ ;
				}
				startCol=0;
			}
			startRow=0;			
		}
		if(count==15){ //printing all the best combinations
			for(int i=0;i<8;i++)
		    {
		           for(int j=0;j<8;j++)
		        {
						System.out.print(board[i][j]+" ");
		            
		        }
		           System.out.println();
		    }
			 System.out.println();
		}				
		return count;  //return the total number of queens
		
	}

	/**
     * Checks if a queen is under attack from another queen.
     * @param row Current row
     * @param col Current column
     * @param board integer array to represent the board
     * @return boolean 
     */
	static boolean isAttacked(int row, int col, int board[][]){
		boolean isAttackedRowCol = false;
		boolean isAttackedDiag = false;
			int rowStart = 0;
			int colStart = 0;
			int rowEnd = 7;
			int colEnd = 7;
			// Initializing the wall in terms of rows and columns
			if (row == 0) {
				if (col <= 5)
					colEnd = 5;
				else {
					colStart = 6;
					colEnd = 7;
				}
			} else if (row == 1) {
				if (col <= 3)
					colEnd = 3;
				else if (col <= 5) {
					colStart = 4;
					colEnd = 5;
				} else {
					colStart = 6;
					colEnd = 7;
				}
			} else if (row == 2) {
				if (col <= 3)
					colEnd = 3;
				else {
					colStart = 4;
					colEnd = 7;
				}
			} else if (row == 3) {
				if (col <= 4)
					colEnd = 4;
				else {
					colStart = 5;
					colEnd = 7;
				}
			} else if (row == 4) {
				if (col <= 1)
					colEnd = 1;
				else if (col <= 4) {
					colStart = 2;
					colEnd = 4;
				} else {
					colStart = 5;
					colEnd = 7;
				}
			} else if (row == 5) {
				if (col <= 1)
					colEnd = 1;
				else {
					colStart = 2;
					colEnd = 7;
				}
			} else if (row == 6) {
				if (col <= 5)
					colEnd = 5;
				else {
					colStart = 6;
					colEnd = 7;
				}
			} else if (row == 7) {
				if (col == 0) {
					colEnd = 0;
				} else if (col <= 5) {
					colStart = 1;
					colEnd = 5;
				} else {
					colStart = 6;
					colEnd = 7;
				}
			}

			if (col == 0) {
				if (row <= 1)
					rowEnd = 1;
				else if (row <= 6) {
					rowStart = 2;
					rowEnd = 6;
				} else {
					rowStart = 7;
					rowEnd = 7;
				}
			} else if (col == 1) {
				if (row <= 1)
					rowEnd = 1;
				else {
					rowStart = 2;
					rowEnd = 7;
				}
			} else if (col == 2) {
				if (row <= 1)
					rowEnd = 1;
				else if (row <= 5) {
					rowStart = 2;
					rowEnd = 5;
				} else {
					rowStart = 6;
					rowEnd = 7;
				}
			} else if (col == 3) {
				if (row <= 2)
					rowEnd = 2;
				else if (row <= 5) {
					rowStart = 3;
					rowEnd = 5;
				} else {
					rowStart = 6;
					rowEnd = 7;
				}
			} else if (col == 4) {
				if (row <= 2)
					rowEnd = 2;
				else if (row <= 5) {
					rowStart = 3;
					rowEnd = 5;
				} else {
					rowStart = 6;
					rowEnd = 7;
				}
			} else if (col == 5) {
				if (row <= 2)
					rowEnd = 2;
				else if (row <= 4) {
					rowStart = 3;
					rowEnd = 4;
				} else {
					rowStart = 5;
					rowEnd = 7;
				}
			} else if (col == 6) {
				if (row <= 4) {
					rowEnd = 4;
				} else {
					rowStart = 5;
					rowEnd = 7;
				}
			} else if (col == 7) {
				if (row <= 4) {
					rowEnd = 4;
				} else {
					rowStart = 5;
					rowEnd = 7;
				}
			}	
			
			isAttackedRowCol = checkRowAndCol(row, rowStart, rowEnd, col, colStart, colEnd, board);
			isAttackedDiag = checkDiagonals(row, rowStart, rowEnd, col, colStart, colEnd, board);
	     if(!isAttackedRowCol&&!isAttackedDiag)//checking if the queen is safe from both rowColumn wise and diagonal wise.
			return false;
	     else
	    	 return true;
  }
	/**
     * Checks if a queen is under attack from another queen in the same row or column.
     * @param row Current row
     * @param rowStart starting row
     * @param rowEnd ending row
     * @param col Current col
     * @param colStart starting column
     * @param colEnd ending column
     * @param board integer array to represent the board
     * @return isAttacked boolean 
     */
	public static boolean checkRowAndCol(int row, int rowStart, int rowEnd, int col, int colStart, int colEnd, int board[][]){
		boolean isAttacked = false;
      		for (int colTemp = colStart; colTemp <= colEnd; colTemp++){
			  if(board[row][colTemp]==1)
				  isAttacked =  true;
			}
			for (int rowTemp = rowStart; rowTemp <= rowEnd; rowTemp++){
			  if(board[rowTemp][col]==1)
				  isAttacked = true;
			}
			return isAttacked;		
	}
	
	/**
     * Checks if a queen is under attack from another queen in the same diagonal
     * @param row Current row
     * @param rowStart starting row
     * @param rowEnd ending row
     * @param col Current col
     * @param colStart starting column
     * @param colEnd ending column
     * @param board integer array to represent the board
     * @return isAttacked boolean 
     */
	public static boolean checkDiagonals(int row, int rowStart, int rowEnd, int col, int colStart, int colEnd, int board[][]){
		boolean isAttacked = false;
		for (int rowTemp = row, colTemp = col; rowTemp >= rowStart && colTemp <= colEnd; rowTemp--, colTemp ++)
		{
			if (board[rowTemp][colTemp] == 1) {
				isAttacked =  true;
			}
		}
		for (int rowTemp = row, colTemp = col; rowTemp <= rowEnd && colTemp >= colStart; rowTemp ++, colTemp --) {
			if (board[rowTemp][colTemp] == 1) {
				isAttacked =  true;
			}
		}
		for (int rowTemp = row, colTemp = col; rowTemp >= rowStart && colTemp >= colStart; rowTemp--, colTemp--) {
			if (board[rowTemp][colTemp] == 1) {
				isAttacked =  true;
			}
		}
		for (int rowTemp = row, colTemp = col; rowTemp <= rowEnd && colTemp <= colEnd; rowTemp ++, colTemp ++) {
			if (board[rowTemp][colTemp] == 1) {
				isAttacked =  true;
			}
		}
			return isAttacked;		
	}
	   
}
     
	



