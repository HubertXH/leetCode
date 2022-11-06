package tree;

import entity.TreeNode;

/**
 * No:236 medium
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * @author hubert
 */
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || null == q) {
            return null;
        }

        if ((root.left == p && root.right == q) || (root.left == q && root.right == p)) {
            return root;
        }
        if (root.right == p || root.left == p) {
            return p;
        }
        if (root.right == q || root.left == q) {
            return q;
        }

        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);

        if (null == leftSearch && null == rightSearch) {
            return null;
        }
        if (null == leftSearch) {
            return rightSearch;
        }
        if (null == rightSearch) {
            return leftSearch;
        }
        return root;
    }
}