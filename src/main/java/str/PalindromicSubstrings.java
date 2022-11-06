package str;

/**
 * No:647. Palindromic Substrings
 * Medium
 * <p>
 * Given a string s, return the number of palindromic substrings in it.
 * <p>
 * A string is a palindrome when it reads the same backward as forward.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * <p>
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 * @author Hubert
 */
public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += caculatePalind(s, i, i);
            count += caculatePalind(s, i, i + 1);
        }
        return count;
    }

    private static int caculatePalind(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("sss"));
    }
}
