package recursiondivide;

/**
 * 62. Unique Paths
 * Medium
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * <p>
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * <p>
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 7
 * ┌───┬───┬───┬───┬───┬───┬───┐
 * │SS │   │   │   │   │   │   │
 * ├───┼───┼───┼───┼───┼───┼───┤
 * │   │   │   │   │   │   │   │
 * ├───┼───┼───┼───┼───┼───┼───┤
 * │   │   │   │   │   │   │TA │
 * └───┴───┴───┴───┴───┴───┴───┘
 * Output: 28
 * Example 2:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 100
 *
 * @author Hubert
 */
public class UniquePaths {

    /**
     * DFS&DP
     */
    public static int uniquePaths(int m, int n) {
        int[][] temps = new int[m][n];
        for (int i = 0; i < m; i++) {
            temps[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            temps[0][i] = 1;
        }
        for (int j = 1; j < m; j++) {
            for (int k = 1; k < n; k++) {
                temps[j][k] = temps[j][k - 1] + temps[j - 1][k];
            }
        }

        return temps[m - 1][n - 1];
    }

    public static void main(String[] args) {

    }
}
