package str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * No:395. Longest Substring with At Least K Repeating Characters
 * Medium
 * <p>
 * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character
 * in this substring is greater than or equal to k.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 * <p>
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^4
 * s consists of only lowercase English letters.
 * 1 <= k <= 10^5
 *
 * @author Hubert
 */
public class LongestSubstringAtLeastKRepeatingCharacters {

    public static int longestSubstring(String s, int k) {
        if (k == 1) {
            return s.length();
        }

        Map<Character, Integer> cMap = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            cMap.put(s.charAt(i), cMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        Map<Character, Integer> nMap = new HashMap<>(26);
        int left = 0, right = 0;
        String temp = "";
        for (; right < s.length(); right++) {
            if (cMap.get(s.charAt(right)) < k) {
                temp = temp.length() > right - left + 1 ? temp : s.substring(left, right);
                left = right;
                for (Map.Entry<Character, Integer> entry : nMap.entrySet()) {
                    if (cMap.containsKey(s.charAt(right))) {
                        cMap.put(entry.getKey(), cMap.get(entry.getKey()) - entry.getValue());
                    }
                }
                nMap.clear();
            }
            nMap.put(s.charAt(right), nMap.getOrDefault(s.charAt(right), 0) + 1);
        }
        System.out.println(temp);
        return temp.length();
    }

    public static int longestSubstringWithSliding(String s, int k) {
        if (k == 1) {
            return s.length();
        }



        return 0;
    }

    public int longestSubstringOne(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            Arrays.fill(countMap, 0);
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < str.length) {
                // expand the sliding window
                if (unique <= currUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0) unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k) countAtLeastK++;
                    windowEnd++;
                }
                // shrink the sliding window
                else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0) unique--;
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK)
                    result = Math.max(windowEnd - windowStart, result);
            }
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }

    public static void main(String[] args) {
        String str = "fromdbasequenceswheresequencenamemaxavavavaavavavaluelastnumberselectsequencename";
//        String str = "aaaccclllddeeeeesssssfffffsss";
        System.out.println(longestSubstring(str, 3));
    }
}
