package tree;

import entity.TreeNode;

public class BinarySearchTreeGreaterSumTree {

    private int tempNum = 0;

    public TreeNode<Integer> bstToGst(TreeNode<Integer> root) {

        if (null == root) {
            return root;
        }


        bstToGst(root.right);
        root.val = root.val + tempNum;
        tempNum = root.val;
        bstToGst(root.left);

        return root;
    }
}
