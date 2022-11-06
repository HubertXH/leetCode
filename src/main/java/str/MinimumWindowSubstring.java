package str;

/**
 * No:79
 *
 * @author hubert
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {

        System.out.println(minWindow("", ""));
    }


    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] chars = new int[128];
        boolean[] flag = new boolean[128];

        for (int i = 0; i < t.length(); i++) {
            flag[t.charAt(i)] = true;
            chars[t.charAt(i)]++;
        }
        int l = 0, cnt = 0, maxIndex = 0, minIndex = 0, minSize = s.length() + 1;
        for (int r = 0; r < s.length(); r++) {
            if (!flag[s.charAt(r)]) {
                continue;
            }
            if (--chars[s.charAt(r)] >= 0) {
                cnt++;
            }
            while (cnt == t.length()) {
                if (r - l + 1 < minSize) {
                    minIndex = l;
                    maxIndex = r;
                    minSize = maxIndex - minIndex + 1;
                }
                if (flag[s.charAt(l)] && ++chars[s.charAt(l)] > 0) {
                    cnt--;
                }
                l++;
            }

        }
        return minSize > s.length() ? "" : s.substring(minIndex, maxIndex + 1);
    }
}
