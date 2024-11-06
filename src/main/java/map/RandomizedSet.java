package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * Medium
 * <p>
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called).
 * Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 * @author hubert
 */
public class RandomizedSet {

    private Map<Integer, Integer> map = new HashMap<>();

    private ArrayList<Integer> nums = new ArrayList<>();

    private Random random = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        nums.add(val);
        map.put(val, nums.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        Integer lastNum = nums.size() > 1 ? nums.get(nums.size() - 1) : null;
        if (null != lastNum) {
            nums.set(index, lastNum);
            map.put(lastNum, index);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(nums.size());
        return nums.get(index);
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"RandomizedSet", "remove", "remove", "insert", "getRandom", "remove", "insert"};
        Integer[] datas = new Integer[]{null, 0, 0, 0, null, 0, 0};
        int operationIndex = 1;
        int dataIndex = 1;
        RandomizedSet rs = new RandomizedSet();
        while (operationIndex < operations.length && dataIndex < datas.length) {
            switch (operations[operationIndex]) {
                case "remove":
                    System.out.println(rs.remove(datas[dataIndex]));
                    operationIndex++;
                    dataIndex++;
                    break;
                case "insert":
                    System.out.println(rs.insert(datas[dataIndex]));
                    operationIndex++;
                    dataIndex++;
                    break;
                case "getRandom":
                    rs.getRandom();
                    operationIndex++;
                    dataIndex++;
                    break;
            }
        }
    }
}
