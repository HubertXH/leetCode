package tree;

import entity.TreeNode;

/**
 * No:111 Easy
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 * <p>
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 * Related Topics
 * Tree
 * Depth-First Search
 * Breadth-First Search
 * Binary Tree
 *
 * @author admin
 */
public class MinimunDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.right && null == root.left) {
            return 1;
        }
        int leftDepth = 1 + minDepth(root.left);
        int rightDepth = 1 + minDepth(root.right);
        return Math.min(leftDepth, rightDepth);
    }
}
