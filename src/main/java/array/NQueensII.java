package array;

/**
 * No:52 Hard
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle
 * <p>
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: 1
 * Constraints:
 * <p>
 * 1 <= n <= 9
 * Related Topics
 * Backtracking
 *
 * @author Hubert
 */
public class NQueensII {

    private static int count = 0;


    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] obliqueLineOne = new boolean[2 * n - 1];
        boolean[] obliqueLineTwo = new boolean[2 * n - 1];
        dfs(0, n, columns, obliqueLineOne, obliqueLineTwo);
        return count;
    }

    public static void dfs(int row, int n, boolean[] columns, boolean[] obliqueLineOne, boolean[] obliqueLineTwo) {
        if (n == row) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns[i] || obliqueLineOne[i + row] || obliqueLineTwo[row - i + n - 1]) {
                continue;
            }
            columns[i] = true;
            obliqueLineOne[row + i] = true;
            obliqueLineTwo[row - i + n - 1] = true;
            dfs(row + 1, n, columns, obliqueLineOne, obliqueLineTwo);
            columns[i] = false;
            obliqueLineOne[row + i] = false;
            obliqueLineTwo[row - i + n - 1] = false;
        }
    }
}
