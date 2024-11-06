package array;

/**
 * 278. First Bad Version
 * Easy
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 * <p>
 * Input: n = 1, bad = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= bad <= n <= 231 - 1
 *
 * 注意考虑integer的最大范围 小心越界问题
 * @author hubert
 */
public class FirstBadVersion extends VersionControl {

    /**
     * binarySearch
     *
     * @param n target
     * @return
     */
    public int firstBadVersion(int n) {
        return findBadVersion(1, n);
    }

    private int findBadVersion(int i, int n) {
        if (i >= n) return i;
        long sum = (long)i + (long)n;
        int mid = (int)(sum / 2);
        if (!isBadVersion(mid)) {
            if (isBadVersion(mid + 1)) {
                return mid + 1;
            }
            return findBadVersion(mid, n);
        } else {
            if (!isBadVersion(mid - 1)) {
                return mid;
            }
            return findBadVersion(i, mid);
        }
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        firstBadVersion.bad = 3;
        System.out.println(firstBadVersion.firstBadVersion(3));
    }
}
