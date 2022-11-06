package tree;

import entity.TreeNode;

/**
 * No.1315
 * <p>
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
 * <p>
 * If there are no nodes with an even-valued grandparent, return 0.
 */
public class SumOfNodesWithEvenValuedGrandparent {

    public int sumEvenGrandparent(TreeNode<Integer> root) {

        if (null == root) {
            return 0;
        }
        int result = 0;

        TreeNode<Integer> leftNode = root.left;
        TreeNode<Integer> rightNode = root.right;

        result += sumEvenGrandparent(leftNode);
        result += sumEvenGrandparent(rightNode);

        if (root.data % 2 != 0) {
            return result;
        }
        if (null != leftNode) {
            if (null != leftNode.left) {
                result += (Integer) leftNode.left.data;
            }
            if (null != leftNode.right) {
                result += (Integer) leftNode.right.data;
            }
        }

        if (null != rightNode) {
            if (null != rightNode.left) {
                result += (Integer) rightNode.left.data;
            }
            if (null != rightNode.right) {
                result += (Integer) rightNode.right.data;
            }
        }

        return result;
    }

}
