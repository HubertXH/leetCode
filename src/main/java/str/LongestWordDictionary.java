package str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a string array dictionary, return the longest string in the dictionary that can be
 * formed by deleting some of the given string characters.
 * If there is more than one possible result, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * Example 2:
 * <p>
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s and dictionary[i] consist of lowercase English letters.
 * Related Topics
 * Array
 * Two Pointers
 * String
 * Sorting
 *
 * @author hubert
 */
public class LongestWordDictionary {

    public static void main(String[] args) {
        System.out.println(findTheLongestWord("abc", Arrays.asList("a", "c")));
    }

    public static String findTheLongestWord(String s, List<String> dictionary) {
        if (null == s || s.length() <= 0) {
            return "";
        }
        if (null == dictionary || dictionary.size() <= 0) {
            return "";
        }
        Map<Character, Integer> charCountMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (!charCountMap.containsKey(s.charAt(i))) {
                charCountMap.put(s.charAt(i), 1);
            } else {
                charCountMap.put(s.charAt(i), charCountMap.get(s.charAt(i)) + 1);
            }
        }
        String result = "";
        int resultNum = Integer.MAX_VALUE;
        for (String str : dictionary) {
            boolean matchSuccess = true;
            Map<Character, Integer> countMap = new HashMap<>(str.length());
            int tempCount = 0;
            for (int l = 0; l < str.length(); l++) {
                if (!charCountMap.containsKey(str.charAt(l))) {
                    matchSuccess = false;
                    break;
                }
                if (!countMap.containsKey(str.charAt(l))) {
                    countMap.put(str.charAt(l), 1);
                } else {
                    if (charCountMap.get(str.charAt(l)) < countMap.get(str.charAt(l)) + 1) {
                        matchSuccess = false;
                        break;
                    }
                    countMap.put(str.charAt(l), countMap.get(str.charAt(l)) + 1);
                }
                tempCount += str.charAt(l);
            }
            if (matchSuccess && str.length() >= result.length() && tempCount < resultNum) {
                result = str;
                resultNum = tempCount;
            }
        }
        return result;
    }
}
