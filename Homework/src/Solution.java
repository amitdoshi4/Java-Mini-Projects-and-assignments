import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author joshi18
 */
public class Solution {

	 boolean board[][] = new boolean[3][3];
    Set<Integer> occupiedColumns = new HashSet<Integer>();


    void setBoard(boolean[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; ++j) {
                if (board[i][j]) {
                    occupiedColumns.add(j);
                }
            } 
        }
    }

    int waysToPlace(int k) {
        if (k == board.length - 1) {
            return 1;
        }
        int totalWays = 0;
        for (int pos = 0; pos < board.length; ++pos) {
            int ways = 1;
            if (!isAttack(k + 1, pos)) {
                board[k + 1][pos] = true;
                occupiedColumns.add(pos);
                ways *= waysToPlace(k + 1);
                board[k + 1][pos] = false;
                occupiedColumns.remove(pos);
            } else {
                ways = 0;
            }
            totalWays += ways;
        }
        return totalWays;
    }

    boolean isAttack(int row, int col) {
        if (occupiedColumns.contains(col)) {
            return true;
        }
        if ((col > 0 && row > 0 && board[row - 1][col - 1]) || (col < board.length - 1 && row > 0 && board[row - 1][col + 1])) {
            return true;
        }
        return false;
    }



    public static void main(String args[]) {
        //Solution sol = new Solution(5);        
        // System.out.println(sol.waysToPlace(-1));
        //sol.printArray();
        readInput();
    } 

    static void readInput() {
       // Scanner scan = new Scanner(System.in);
        int t = 1;
        for (int i = 0; i < t; ++i) {
           // int n = scan.nextInt();
            //System.out.println(" n "+n );            
            int k = 3;
            // System.out.println(" k "+k );
            boolean board[][] = new boolean[4][4];
          //  for (int row = 0; row < k; ++row) {
            //    int col = 3;;
              //  board[row][col] = true;
            //}
            
            Solution s = new Solution();
           // s.setBoard(board);
            int ways = s.waysToPlace(k - 1);
            System.out.println("Ways:" +ways);
        }
    }
}