package recursiondivide;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * No:22 Medium
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * Constraints:
 * <p>
 * 1 <= n <= 8
 * Related Topics
 * String
 * Dynamic Programming
 * Backtracking
 *
 * @author hubert
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generateParenthesis(3)));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> resultList = new ArrayList<>();
        if (n < 1) {
            return resultList;
        }
        combinationsList(resultList, new StringBuilder(), 0, 0, n);
        return resultList;
    }

    public static void combinationsList(List<String> resultList, StringBuilder stringBuilder, int left, int right, int n) {
        if (left == right && left == n) {
            resultList.add(stringBuilder.toString());
            return;
        }
        if (left < n) {
            combinationsList(resultList, stringBuilder.append("("), left + 1, right, n);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (right < left) {
            combinationsList(resultList, stringBuilder.append(")"), left, right + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
