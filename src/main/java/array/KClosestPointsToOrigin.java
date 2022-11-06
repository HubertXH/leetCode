package array;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * No:973 Medium
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)^2 + (y1 - y2)^2).
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= points.length <= 10^4
 * -10^4 < xi, yi < 10^4
 *
 * @author Hubert
 */
public class KClosestPointsToOrigin {

    /**
     * 维护一个最大堆。
     */
    public static int[][] kClosest(int[][] points, int k) {
        int[][] resultList = new int[k][2];
        PriorityQueue<int[]> priorityQueue1 = new PriorityQueue<>(k, (o1, o2) -> Integer.compare(o2[0] * o2[0] + o2[1] * o2[1], o1[0] * o1[0] + o1[1] * o1[1]));
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(k);
        for (int[] point : points) {
            int score = point[0] * point[0] + point[1] * point[1];
            if (priorityQueue.size() >= k && priorityQueue.peek().score > score) {
                priorityQueue.remove();
            }
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Node(point, score));
            }
        }
        priorityQueue.stream().map(queue -> queue.point).collect(Collectors.toList()).toArray(resultList);
        return resultList;
    }

    public static int[][] kClosestByArraySort(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOf(points, k);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{5, 6}, {3, 17}, {6, 16}, {17, 5}, {20, 15}, {11, 3}, {11, 10}, {11, 5}, {7, 11}, {13, 7}, {5, 13}, {19, 15}, {4, 2}, {19, 7}, {9, 8}};

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        int[][] result1 = kClosestByArraySort(points, 10);
        System.out.println(gson.toJson(result1));

        int[][] result2 = kClosest(points, 10);
        System.out.println(gson.toJson(result2));
    }

    static class Node implements Comparable<Node> {

        int score;
        int[] point;

        Node(int[] point, int score) {
            this.point = point;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.score, score);
        }
    }
}
