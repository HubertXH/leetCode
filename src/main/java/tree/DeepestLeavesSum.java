package tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.1302
 *
 * Given a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum {

    public int deepestLeavesSumResult(TreeNode<Integer> root) {
        if (null == root) {
            return 0;
        }
        int result = 0;
        int i = 0;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (i = queue.size() - 1, result = 0; i >= 0; --i) {
                TreeNode<Integer> currentNode = queue.poll();
                result += currentNode.data;
                if (null != currentNode.left) {
                    queue.offer(currentNode.left);
                }
                if (null != currentNode.right) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
}
