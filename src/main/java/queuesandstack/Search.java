package queuesandstack;


public class Search {

    static int f[];


    public static Integer sequentialSearch(int[] arry, int n, int key) {

        int i = 0;

        arry[0] = key;

        i = n;

        while (arry[i] != key) {
            i--;
        }
        return i;
    }

    /**
     * binary search
     *
     * @param array search array
     * @param n    array length
     * @param key  search target
     * @return target index at array
     */
    public Integer binarySearch(int[] array, int n, int key) {
        int low, high, mid;
        low = 1;
        high = n;

        while (low < high) {

            mid = (low + high) / 2;

            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }


    public Integer intoSearch(int[] arry, int n, int key) {

        int low, high, mid;

        low = 1;
        high = n;

        while (low < high) {
            mid = low + (high - low) * (key - arry[low]) / (arry[high] - arry[low]);

            if (key < arry[mid]) {
                high = mid - 1;
            } else if (key > arry[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }


    static Integer Fbi(int i) {
        if (i < 2)
            return i == 0 ? 0 : 1;
        return Fbi(i - 1) + Fbi(i - 2);
    }


    public static int[] getF(int n) {

        for (int i = 0; i < n; i++) {
            f[i] = Fbi(n);
        }

        return f;
    }


    public Integer fibonacciSearch(int[] arry, int n, int key) {

        int low, high, mid, i = 0, k;

        low = 1;
        high = n;
        k = 0;

        while (key > f[i] - 1) {

            k++;

            for (i = n; i < f[k] - 1; i++) {

                arry[i] = arry[n];
            }
        }

        while (low < high) {
            mid = low + f[k - 1] - 1;

            if (key < arry[mid]) {

                high = mid - 1;
                k = k - 1;
            } else if (key > arry[mid]) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid <= n) {
                    return mid;
                } else {
                    return n;
                }
            }
        }

        return 0;
    }

}
