package array;

/**
 * No:122 Medium
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 * <p>
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 * Constraints:
 * <p>
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 * Related Topics
 * Array
 * Dynamic Programming
 * Greedy
 *
 * @author Hubert
 */
public class BestTimeBuyAndSellStockTwo {

    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        System.out.println(maxProfit(array));
    }

    public static int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int buyPrice = 0;
        for (int i = 0; i <= prices.length - 1; i++) {
            if (buyPrice <= 0) {
                if (i == prices.length - 1) {
                    continue;
                }
                if (prices[i] < prices[i + 1]) {
                    buyPrice = prices[i];
                }
            } else {
                if (i == prices.length - 1) {
                    profit += (prices[i] - buyPrice);
                    buyPrice = 0;
                    continue;
                }
                if (prices[i] < prices[i + 1]) {
                } else {
                    profit += (prices[i] - buyPrice);
                    buyPrice = 0;
                }
            }
        }
        return profit;
    }
}
