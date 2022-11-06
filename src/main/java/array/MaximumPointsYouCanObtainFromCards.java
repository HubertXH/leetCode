package array;

/**
 * No:1423. Maximum Points You Can Obtain from Cards
 * Medium
 * There are several cards arranged in a row, and each card has an associated number of points.
 * The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1.
 * However, choosing the rightmost card first will maximize your total score.
 * The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * Example 2:
 * <p>
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 * Example 3:
 * <p>
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= cardPoints.length <= 105
 * 1 <= cardPoints[i] <= 104
 * 1 <= k <= cardPoints.length
 *
 * @author Hubert
 */
public class MaximumPointsYouCanObtainFromCards {

    /**
     * DP
     * 如果从数组左侧取零个卡片，则剩余的需要从数组右侧获取，数量为K; 总分数为 totalScore[0]
     * 如果从数组左侧取一个卡片，则剩余的需要从数组右侧获取，数量为k-1; 总分数为 totalScore[0]+cardPoints[0]-cardPoints[cardPoints.length - 1 - k + 1];
     * 如果从数组左侧取两个卡片，则剩余的需要从数组右侧获取，数量为k-2; 总分数为 totalScore[1]+cardPoints[1]-cardPoints[cardPoints.length - 1 - k + 2];
     * ...
     * 如果从数组左侧取N个卡片，则剩余的需要从数组右侧获取，数量为k-N; 总分数为 totalScore[N-1]+cardPoints[N-1]-cardPoints[cardPoints.length - 1 - k + N];
     * 所有最大值即为找到以上组合的最大分数,将个组合所得分数存储下来，每次与最大值进行比较即可。
     */
    public static int maxScore(int[] cardPoints, int k) {

        int[] totalSore = new int[k + 1];

        for (int i = cardPoints.length - 1; i > cardPoints.length - 1 - k; i--) {
            totalSore[0] += cardPoints[i];
        }

        int maxScore = totalSore[0];
        for (int left = 1; left <= k; left++) {
            totalSore[left] = totalSore[left - 1] + cardPoints[left - 1] - cardPoints[cardPoints.length - 1 - k + left];
            maxScore = Math.max(maxScore, totalSore[left]);
        }
        return maxScore;
    }

    /**
     * 与DP的思路基本相同，计算各种不同的组合然后取最大值
     */
    public static int maxScoreArray(int[] cardPoints, int k) {
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += cardPoints[i];
        }
        int tempScore = result;
        for (int i = k - 1; i >= 0; i--) {
            tempScore = tempScore - cardPoints[i] + cardPoints[cardPoints.length - (k - i)];
            result = Math.max(tempScore, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{12, 2, 10, 8, 14, 15, 2, 1, 11, 0, 0, 16, 9, 18, 3, 8};
        System.out.println(maxScore(array, 6));
        System.out.println(maxScoreArray(array, 6));
    }
}
