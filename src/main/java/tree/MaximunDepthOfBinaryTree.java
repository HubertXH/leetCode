package tree;

import entity.TreeNode;

/**
 * No:104 Easy
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 * Related Topics
 * Tree
 * Depth-First Search
 * Breadth-First Search
 * Binary Tree
 *
 * @author Hubert
 */
public class MaximunDepthOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(maxDepth(null));
    }


    public static int maxDepth(TreeNode<Integer> root) {
        if (null == root) {
            return 0;
        }
        if (null == root.right && null == root.left) {
            return 1;
        }
        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }


}
