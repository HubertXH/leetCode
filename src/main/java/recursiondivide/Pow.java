package recursiondivide;

/**
 * No:50 medium
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/2*2 = 1/4 = 0.25
 * Constraints:
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * Related Topics
 * Math
 * Recursion
 *
 * @author admin
 */
public class Pow {

    public static void main(String[] args) {
        System.out.println(myPow(-3, 9));
        System.out.println(Math.pow(-3,9.00));
    }


    public static double myPow(double x, int n) {
        if (0 == n) {
            return 1;
        }
        if (0 == x) {
            return 0.00;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            return n % 2 == 0 ? 1 : -1;
        }
        if (n > 0) {
            return n % 2 == 0 ? myPow(x, n / 2) * myPow(x, n / 2) : x * myPow(x, (n - 1) / 2) * myPow(x, (n - 1) / 2);
        } else {
            return 1 / myPow(x, -n);
        }
    }

}
