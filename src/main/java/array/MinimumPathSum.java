package array;

/**
 * No:64. Minimum Path Sum
 * Medium
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * @author Hubert
 */
public class MinimumPathSum {


    /**
     * DP：result[i][j]  = Math.min(result[i-1][j],result[i][j-1]) + grid[i][j]
     */
    public static int minPathSum(int[][] grid) {

        int[][] temps = new int[grid.length][grid[0].length];
        minPathSumHelp(temps, grid.length - 1, grid[0].length - 1, grid);
        return temps[grid.length - 1][grid[0].length - 1];
    }

    private static void minPathSumHelp(int[][] temps, int n, int m, int[][] grid) {

        for (int i = 0; i < temps.length; i++) {
            for (int j = 0; j < temps[0].length; j++) {
                if (0 == i && 0 == j) {
                    temps[i][j] = grid[i][j];
                } else if (0 == i) {
                    temps[i][j] = temps[i][j - 1] + grid[i][j];
                } else if (0 == j) {
                    temps[i][j] = temps[i - 1][j] + grid[i][j];
                } else {
                    temps[i][j] = Math.min(temps[i - 1][j], temps[i][j - 1]) + grid[i][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
