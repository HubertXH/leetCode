package tree;

import entity.TreeNode;
import com.alibaba.fastjson.JSON;

/**
 * 654
 * <p>
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 */
public class MaximumBinaryTree {

    public static TreeNode<Integer> solution(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return null;
        }
        int[] sortArrays = new int[10];
        for (int index = 0; index < nums.length; index++) {
            if (0 == index) {
                sortArrays[nums[index]] = -1;
            } else {
                sortArrays[nums[index]] = index;
            }
        }
        TreeNode root = null;
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        for (int index = sortArrays.length - 1; index > 0; index--) {
            if (sortArrays[index] == 0) {
                continue;
            }
            if (null == root) {
                root = new TreeNode(index);
                continue;
            }

            if (sortArrays[root.val] > sortArrays[index]) {
                if (null == leftNode) {
                    leftNode = new TreeNode(index);
                    root.left = leftNode;
                    continue;
                }
                if (sortArrays[leftNode.val] > sortArrays[index]) {
                    leftNode.left = new TreeNode(index);
                    leftNode = leftNode.left;
                    continue;
                }
                leftNode.right = new TreeNode(index);
                leftNode = leftNode.right;
                continue;
            }
            if (null == rightNode) {
                rightNode = new TreeNode(index);
                root.right = rightNode;
                continue;
            }
            if (sortArrays[rightNode.val] > sortArrays[index]) {
                rightNode.left = new TreeNode(index);
                rightNode = rightNode.left;
                continue;
            }
            rightNode.right = new TreeNode(index);
            rightNode = rightNode.right;

        }
        return root;
    }


    public static void main(String[] args) {
        String regx = "[^\u4e00-\u9fa5a-zA-Z0-9\"\',\\.\\?:]";

        int[] nums = new int[]{6,5,4,3,2,1};
        System.out.println(JSON.toJSONString(solution(nums)));
    }
}
