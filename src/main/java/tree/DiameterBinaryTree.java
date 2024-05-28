package tree;

import entity.TreeNode;

/**
 * No:543 Easy
 * <p>
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 * <p>
 * Input: root = [1,2]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 *
 * @author Hubert
 */
public class DiameterBinaryTree {

    private int maxPathLength = 0;


    /**
     * DFS&RECURSION
     *
     * 求一个二叉树的直径可以理解为计算一个节点下左右两个子节点各自最大深度的和。
     * 可以采用递归的方式使进行深度遍历优先从叶子节点逐个计算每个计算的直径，在计算的过程找出最大节点直径即可
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxPathCalculate(root);
        return maxPathLength;
    }

    private int maxPathCalculate(TreeNode node) {
        if (null == node) {
            return 0;
        }
        // calculate depth of left node
        int leftLength = maxPathCalculate(node.left);
        // calculate depth of right node
        int rightLength = maxPathCalculate(node.right);
        // find current node's maxPathLength
        maxPathLength = Math.max(leftLength + rightLength, maxPathLength);
        // find current node maximun of depth
        return Math.max(leftLength, rightLength) + 1;
    }
}
