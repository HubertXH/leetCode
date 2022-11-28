package array;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * No:295. Find Median from Data Stream
 * Hard
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value,
 * and the median is the mean of the two middle values.
 * <p>
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * <p>
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10^-5 of the actual answer will be accepted.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -10^5 <= num <= 10^5
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 104 calls will be made to addNum and findMedian.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 * If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 *
 * @author hubert
 */
public class FindMedianDataStream {

    List<Integer> nums = new ArrayList<>();

    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));


    public FindMedianDataStream() {

    }

    public void addNum(int num) {
        nums.add(num);
        Collections.sort(nums);
    }

    public double findMedian() {
        int index = nums.size() / 2;
        if (nums.size() % 2 == 0) {
            return (double) (nums.get(index) + nums.get(index - 1)) / 2;
        } else {
            return (double) nums.get(index);
        }
    }

    public void addNum2(int num) {
        minQueue.add(num);
        if (minQueue.size() > maxQueue.size() + 1) {
            maxQueue.add(minQueue.poll());
        }
    }

    public double findMedian2() {
        if (maxQueue.isEmpty() && minQueue.isEmpty()) {
            return 0.0d;
        }
        if (maxQueue.isEmpty()) {
            return minQueue.peek();
        }
        return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
        Collections.sort(list);
        System.out.println(JSON.toJSONString(list));
        Collections.sort(list, (o1, o2) -> Integer.compare(o2, o1));
        System.out.println(JSON.toJSONString(list));
    }
}
