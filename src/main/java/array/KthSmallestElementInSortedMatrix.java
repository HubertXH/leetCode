package array;

import java.util.PriorityQueue;

/**
 * No:378. Kth Smallest Element in a Sorted Matrix
 * Medium
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * You must find a solution with a memory complexity better than O(n2).
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 * Example 2:
 * <p>
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
 * 1 <= k <= n2
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
 * Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
 *
 * @author hubert
 */
public class KthSmallestElementInSortedMatrix {


    public int kthSmallest(int[][] matrix, int k) {
        return helperByMaxStack(matrix, k);
    }

    /**
     * 维护一个最大堆，堆容量为 K；则堆定元素为所求结果。
     * 时间负责度（n*m*logK）
     */
    private int helperByMaxStack(int[][] matrix, int k) {

        PriorityQueue<Integer> maxStack = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxStack.add(matrix[i][j]);
                if (maxStack.size() > k) {
                    maxStack.poll();
                }
            }
        }
        return maxStack.peek();
    }

    /**
     * 使用二分查找的思想，
     */
    private int helperByBinarySearch(int[][] matrix, int k) {
        int minNum = matrix[0][0], maxNum = matrix[matrix.length - 1][matrix[0].length - 1];
        int result = 0;
        while (minNum < maxNum) {
            int midNum = (minNum + maxNum) / 2;
            if (countLeftNum(matrix, midNum) >= k) {
                maxNum = midNum - 1;
                result = midNum;
            } else {
                minNum = midNum + 1;
            }
        }
        return result;
    }

    /**
     * 思路同 74：Search a 2D Matrix;从右上角开始.
     */
    private int countLeftNum(int[][] matrix, int midNum) {
        int row = 0, clown = matrix[0].length - 1;
        int count = 0;
        for (; row < matrix.length; row++) {
            while (midNum < matrix[row][clown]) {
                clown--;
            }
            if (matrix[row][clown] <= midNum) {
                count += clown;
            }
        }
        return count;
    }

}
