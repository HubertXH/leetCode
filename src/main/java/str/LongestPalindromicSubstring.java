package str;

/**
 * No:5. Longest Palindromic Substring
 * Medium
 * <p>
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * A string is called a palindrome string if the reverse of that string is the same as the original string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 *
 * @author Hubert
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }
        String temp = "";
        for (int i = 0; i < s.length() - 1; i++) {
            int left = 0, right = 0;
            if (s.charAt(i) == s.charAt(i + 1)) {
                left = i;
                right = i + 1;
            } else {
                left = i - 1;
                right = i + 1;
            }
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }
            temp = temp.length() > right - left - 1 ? temp : s.substring(left + 1, right);
        }
        return temp;
    }

    public static void main(String[] args) {
        String str = "adfasdjflassjacvbjlijojiljbvcakfjsalcvbjlijojiljbvcwenfldsnsalfjlbaacvbjlijojiljbvcaablsd";
        System.out.println(longestPalindrome(str));
    }
}
