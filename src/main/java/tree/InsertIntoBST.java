package tree;

import entity.TreeNode;

/**
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
 * insert the value into the BST. Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 *
 * Note that there may exist multiple valid ways for the insertion,
 * as long as the tree remains a BST after insertion.
 * You can return any of them.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * This tree is also valid:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 */
public class InsertIntoBST {

    public TreeNode<Integer> solution(TreeNode<Integer> root, int val) {

        if (null == root) {
            return null;
        }

        TreeNode<Integer> currentNode = root;

        while (null != currentNode) {
            if (currentNode.val == val) {
                break;
            }
            if (currentNode.val > val && null == currentNode.left) {
                currentNode.left = new TreeNode<Integer>(val);
                break;
            }
            if (currentNode.val < val && null == currentNode.right) {
                currentNode.right = new TreeNode<Integer>(val);
                break;
            }
            currentNode = currentNode.val > val ? currentNode.left : currentNode.right;
        }
        return root;
    }
}
