package recursiondivide;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * No.54
 * Medium
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * @author hengxu
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        int top = 0, left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        List<Integer> resultList = new ArrayList<>();
        while (top <= bottom && left <= right) {

            // 从最上面一行的左边向右边进行遍历，结束后将top+1
            for (int i = left; i <= right; i++) {
                resultList.add(matrix[top][i]);
            }
            top++;
            // 从最右边最上面开始向下遍历，结束后将right减1
            for (int i = top; i <= bottom; i++) {
                resultList.add(matrix[i][right]);
            }
            right--;
            // 从最底层一行右边开始向左遍历，结束后将bottom+1
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    resultList.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // 从最左边的最底层开始向上遍历，结束后left+1;
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    resultList.add(matrix[i][left]);
                }
                left++;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(JSON.toJSONString(spiralOrder(matrix)));
    }
}
