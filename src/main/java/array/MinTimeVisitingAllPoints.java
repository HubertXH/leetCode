package array;

/**
 * On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.
 * <p>
 * You can move according to the next rules:
 * <p>
 * In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
 * You have to visit the points in the same order as they appear in the array.
 * <p>
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 * Example 2:
 * <p>
 * Input: points = [[3,2],[-2,2]]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 */
public class MinTimeVisitingAllPoints {

    public static int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        if (null == points || points.length <= 0) {
            return result;
        }
        for (int i = 0; i < points.length - 1; i++) {
            result += calculateMinTimeBetweenTwoPoints(points[i], points[i + 1]);
        }
        return result;
    }

    private static int calculateMinTimeBetweenTwoPoints(int[] point, int[] destination) {

        int time = 0;
        while (point[0] != destination[0] || point[1] != destination[1]) {
            if (point[0] < destination[0]) {
                point[0] += 1;
            } else if (point[0] > destination[0]) {
                point[0] -= 1;
            }
            if (point[1] < destination[1]) {
                point[1] += 1;
            } else if (point[1] > destination[1]) {
                point[1] -= 1;
            }
            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        minTimeToVisitAllPoints(points);
    }
}
