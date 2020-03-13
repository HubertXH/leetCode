package array;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1299
 * <p>
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 * and replace the last element with -1.
 * After doing so, return the array.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 *
 * solution: from back to froward.
 */
public class ReplaceElements {

    public static int[] solution(int[] arr) {

        if (null == arr || arr.length <= 0) {
            return arr;
        }
        int maxNum = arr[arr.length - 1];
        for (int index = arr.length - 2; index >= 0; index--) {
            int tempNum = arr[index];
            arr[index] = maxNum;
            maxNum = maxNum > tempNum ? maxNum : tempNum;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        int[] result = solution(new int[]{18, 15, 5, 22, 9, 18, 5, 21, 9, 18, 20, 14, 19, 3});
        System.out.println(JSON.toJSONString(result));
    }
}
