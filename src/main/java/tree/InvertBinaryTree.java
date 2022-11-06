package tree;

import entity.TreeNode;

/**
 * No:226. Invert Binary Tree
 * Easy
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 *
 * @author Hubert
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }

        if (null != root.left) {
            invertTree(root.left);
        }
        if (null != root.right) {
            invertTree(root.right);
        }
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;
        return root;
    }
}
