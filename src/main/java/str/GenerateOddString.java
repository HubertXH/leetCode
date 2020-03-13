package str;

import org.apache.commons.lang3.StringUtils;

/**
 * 1374
 * <p>
 * Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.
 * <p>
 * The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4
 * Output: "pppz"
 * Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs once.
 * Note that there are many other valid strings such as "ohhh" and "love".
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: "xy"
 * Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once.
 * Note that there are many other valid strings such as "ag" and "ur".
 * Example 3:
 * <p>
 * Input: n = 7
 * Output: "holasss"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 500
 */
public class GenerateOddString {

    public String solution(int n) {

        char x = 'x';
        char y = 'y';

        StringBuilder result = new StringBuilder();

        if (n % 2 == 0) {
            for (int i = 1; i <= n - 1; i++) {
                result.append(x);
            }
            result.append(y);
        } else {
            for (int i = 1; i <= n; i++) {
                result.append(x);
            }
        }

        return result.toString();
    }
}
