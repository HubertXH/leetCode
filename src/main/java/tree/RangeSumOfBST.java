package tree;

import Entity.TreeNode;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */
public class RangeSumOfBST {


    public int rangeSumBST(TreeNode<Integer> root, int L, int R) {

        int result = 0;
        int value = root.data;
        if (value <= R && value >= L) {
            result += value;
        }
        if (null != root.left) {
            result += rangeSumBST(root.left, L, R);
        }
        if (null != root.right) {
            result += rangeSumBST(root.right, L, R);
        }
        return result;
    }
}
