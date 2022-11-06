package queuesandstack;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * No:347. Top K Frequent Elements Medium
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author Hubert
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> table = new HashMap<>(nums.length);
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> table.getOrDefault(o, 1)));
        for (int num : nums) {
            if (!table.containsKey(num)) {
                table.put(num, 0);
            }
            table.put(num, table.get(num) + 1);
            if (set.contains(num)) {
                continue;
            }
            if (priorityQueue.size() >= k && table.get(priorityQueue.peek()) < table.get(num)) {
                set.remove(priorityQueue.remove());
            }
            if (priorityQueue.size() < k) {
                priorityQueue.offer(num);
                set.add(num);
            }
        }
        return priorityQueue.stream().mapToInt(p -> p).toArray();
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{4,2,4,2,9,9,4,5,2,1,4,2,2,1,1,9,9,8,9,3,6,8,8,5,8,6,2,3,1,3};
        System.out.println(JSON.toJSONString(topKFrequent(arrays, 4)));
    }
}
