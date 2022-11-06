package tree;

import entity.TreeNode;

import java.util.*;

/**
 * No:103
 * Medium
 * <p>
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 *
 * @author Hubert
 */
public class BinaryTreeZigzagLevelOrderTraversal {


    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        if (null == root) {
            return new ArrayList<>(0);
        }
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= queue.size(); j++) {
                TreeNode<Integer> node = queue.poll();
                if (i % 2 == 1) {
                    list.add(node.data);
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                } else {
                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                }
            }
            result.add(list);
            i++;
        }
        return result;
    }


}
