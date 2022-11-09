package tree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * No:105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 *
 * @author Hubert
 */
public class ConstructBinaryTreePreorderInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return treeHelper(0, 0, inorder.length - 1, preorder, inorder);

    }

    /**
     * 因为前序遍历的顺序为 根->左->右，所以preorder数组中的第一元素为二叉树的根结点。
     * 中序遍历的顺序为 左->根->右 则根据在preorder中找到的根节点位置可以得知，根节点之前的元素为左子树，根结点之后的元素为 右子树。
     * 将中序数组根据根元素一分为二分别继续循环构建二叉树即可。
     */
    private TreeNode treeHelper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {

        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;
        for (int i = 0; i < inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = treeHelper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // preStart+inIndex-inStart+1 在 inStart和inIndex之间的所有元素均为左子树的元素。 preStart跳过所有左子树的元素即为右子树的根结点
        root.right = treeHelper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
