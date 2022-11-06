package tree;

import entity.TreeNode;

/**
 * No:98 Medium
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * @author admin
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (null == root || null == root.left || null == root.right) {
            return true;
        }
        if (root.val <= root.left.val || root.val >= root.right.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
