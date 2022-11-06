package array;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;

/**
 * No:56 Medium
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 *
 * @author Hubert
 */
public class MergeIntervals {

    /**
     * 双指针
     */
    public static int[][] merge(int[][] intervals) {
        if (null == intervals || intervals.length <= 1) {
            return intervals;
        }
        // 按照二维数组中第一个数进行升序排序，保证整个二维是升序的，减少复杂度
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        System.out.println(JSON.toJSONString(intervals));
        int firstPoint = 1;
        int behindPoint = 0;
        for (; firstPoint < intervals.length; firstPoint++) {
            if (intervals[behindPoint][1] < intervals[firstPoint][0]) {
                behindPoint++;
                intervals[behindPoint] = intervals[firstPoint];
                continue;
            }
            if (intervals[behindPoint][1] >= intervals[firstPoint][1]) {
                continue;
            }
            if (intervals[behindPoint][1] < intervals[firstPoint][1]) {
                intervals[behindPoint][1] = intervals[firstPoint][1];
            }
        }
        return Arrays.copyOf(intervals, behindPoint + 1);
    }

    public static void main(String[] args) {
        int[][] arrays = new int[][]{{4, 13}, {9, 14}, {36, 41}, {49, 50}, {41, 45}, {48, 57}, {13, 16}, {21, 24}, {28, 30}, {47, 53}};
        int[] sortList = new int[]{5, 5, 3, 7, 6, 80, 4, 3, 56, 7, 10};
        System.out.println(JSON.toJSONString(merge(arrays)));
        Arrays.sort(sortList);
        System.out.println(JSON.toJSONString(sortList));
    }
}
