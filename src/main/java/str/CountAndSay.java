package str;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static String solution(int n) {
        if (n < 1 || n > 30) {
            throw new IndexOutOfBoundsException("please check the n,insure that n is low 30 and large 0");
        }
        String originStr = "1";
        for (int num = 1; num < n; num++) {
            originStr = readAndSay(originStr);
        }
        return originStr;
    }

    private static String readAndSay(String originStr) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        Character temp = null;
        for (int i = 0; i < originStr.length(); i++) {
            if (null == temp) {
                temp = originStr.charAt(i);
                count++;
            } else if (temp == originStr.charAt(i)) {
                count++;
            } else if (temp != originStr.charAt(i)) {
                builder.append(count).append(String.valueOf(temp));
                temp = originStr.charAt(i);
                count = 1;
            }
            if (i == originStr.length() - 1) {
                builder.append(count).append(String.valueOf(temp));
            }
        }
        return builder.toString();
    }
}
