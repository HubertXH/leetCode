package tree;

import Entity.TreeNode;

public class BinarySearchTreeGreaterSumTree {

    private int tempNum = 0;

    public TreeNode<Integer> bstToGst(TreeNode<Integer> root) {

        if (null == root) {
            return root;
        }


        bstToGst(root.right);
        root.number = root.number + tempNum;
        tempNum = root.number;
        bstToGst(root.left);

        return root;
    }
}
