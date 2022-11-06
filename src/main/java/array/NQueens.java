package array;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * No:51 Hard
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space, respectively.
 * <p>
 * <p>
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: [["Q"]]
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 9
 * Related Topics
 * Array
 * Backtracking
 *
 * @author Hubert
 */
public class NQueens {

    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(5);
        System.out.println(JSON.toJSONString(result));
    }

    private static final Set<Integer> COLUMN = new HashSet<>();
    private static final Set<Integer> OBLIQUE_LINE_ONE = new HashSet<>();
    private static final Set<Integer> OBLIQUE_LINE_TWO = new HashSet<>();

    /**
     * 使用DFS递归调用的方式进行，方法的时间复杂度为O(n(n!)),
     * 整体思路：每一个Queue所在列和其所在的斜上和斜下均不可以放置其他的Queue,
     * 将不可存放的位置存起来用于下一个Queue放置时进行判断
     *
     * @param n 多少个Queue
     * @return 各个可以防止的可能性
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, n);
        return res;
    }

    private static void dfs(List<List<String>> res, List<String> list, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 判断当前位置能否防止Queue，包含了当前列是否有其他Queue,当前位置是否为其他Queue的斜列之上。
            if (COLUMN.contains(i) || OBLIQUE_LINE_ONE.contains(row + i) || OBLIQUE_LINE_TWO.contains(row - i)) {
                continue;
            }

            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);

            list.add(rowString);
            COLUMN.add(i);
            OBLIQUE_LINE_ONE.add(row + i);
            OBLIQUE_LINE_TWO.add(row - i);

            dfs(res, list, row + 1, n);

            list.remove(list.size() - 1);
            COLUMN.remove(i);
            OBLIQUE_LINE_ONE.remove(row + i);
            OBLIQUE_LINE_TWO.remove(row - i);
        }
    }
}
