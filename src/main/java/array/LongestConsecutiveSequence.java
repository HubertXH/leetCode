package array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 128. Longest Consecutive Sequence
 * Medium
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 * @author Hubert
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> allNum = new HashSet<>();
        HashSet<Integer> judeNum = new HashSet<>();
        int count = 0;
        int start = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            allNum.add(num);
            start = Math.min(start, num);
            max = Math.max(max, num);
        }
        while (start <= max) {
            if (allNum.contains(start) && !judeNum.contains(start)) {
                judeNum.add(start);
                count++;
                start++;
                continue;
            }
            count = 0;
            start++;
        }
        return count;
    }

    public static int longestConsecutiveTwo(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);

                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{10, 14, 0, 16, 15, 4, 8, 1, 2, 10, 12, 4, 9, 12, 16, 13};
        System.out.println(longestConsecutive(arrays));
        System.out.println(longestConsecutiveTwo(arrays));
    }
}
