package array;

/**
 * NO:605
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time
 *
 * @author admin
 */
public class MergeTwoArrays {

    public static void main(String[] args) {

    }

    public static void mergeTwoArrays(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int nums1LastIndex = m - 1, nums2LastIndex = n - 1, newArrayLastIndex = m + n - 1;
        for (; newArrayLastIndex >= 0; newArrayLastIndex--) {
            if (nums1LastIndex < 0 && nums2LastIndex < 0) {
                continue;
            }
            if (nums1LastIndex >= 0 && nums2LastIndex < 0) {
                nums1[newArrayLastIndex] = nums1[nums1LastIndex];
                nums1LastIndex--;
                continue;
            }
            if (nums2LastIndex >= 0 && nums1LastIndex < 0) {
                nums1[newArrayLastIndex] = nums2[nums2LastIndex];
                nums2LastIndex--;
                continue;
            }
            if (nums1[nums1LastIndex] >= nums2[nums2LastIndex]) {
                nums1[newArrayLastIndex] = nums1[nums1LastIndex];
                nums1LastIndex--;
            } else {
                nums1[newArrayLastIndex] = nums2[nums2LastIndex];
                nums2LastIndex--;
            }
        }
    }
}
