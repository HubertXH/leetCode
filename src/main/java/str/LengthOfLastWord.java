package str;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {

    public static int solution(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int conut = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                conut++;
                continue;
            }
            break;
        }
        return conut;
    }

    public static void main(String[] args) {
        System.out.println(solution("A word is defined as a character sequence consists of non-space characters "));
    }
}
