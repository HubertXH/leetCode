package str;

import org.apache.commons.lang3.StringUtils;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(solution("1010", "1011"));
    }

    public static String solution(String a, String b) {
        return null == a ? (null == b ? StringUtils.EMPTY : b) : (null == b ? a : addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int temp = 0;
        String result = "";
        while (i >= 0 || j >= 0) {
            int anum = i >= 0 ? Integer.valueOf(String.valueOf(a.charAt(i))) : 0;
            int bnum = j >= 0 ? Integer.valueOf(String.valueOf(b.charAt(j))) : 0;
            int x = anum + bnum + temp;
            temp = 0;
            if (x == 2) {
                temp = 1;
                x = 0;
            } else if (x == 3) {
                temp = 1;
                x = 1;
            }
            result = x + result;
            i--;
            j--;
        }
        if (temp > 0) {
            result = temp + result;
        }
        return result;
    }
}
