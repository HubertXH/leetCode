package list;

/**
 * 1472. Design Browser History
 * Medium
 * <p>
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.
 * <p>
 * Implement the BrowserHistory class:
 * <p>
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps.
 * Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps.
 * Return the current url after forwarding in history at most steps.
 * <p>
 * Example:
 * <p>
 * Input:
 * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
 * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
 * Output:
 * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
 * <p>
 * Explanation:
 * BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
 * browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
 * browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
 * browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
 * browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
 * browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
 * browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
 * browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
 * browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
 * browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
 * browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= homepage.length <= 20
 * 1 <= url.length <= 20
 * 1 <= steps <= 100
 * homepage and url consist of  '.' or lower case English letters.
 * At most 5000 calls will be made to visit, back, and forward.
 * <p>
 * 使用数组来存储
 * 用index表示当前所在页面下标值
 * 使用dataLength表示当前记录的访问长度。
 *
 * @author Hubert
 * @date
 */
public class BrowserHistory {

    private String[] data = new String[500];

    private int index = 0;

    private int dataLength = 0;

    /**
     * 初始化一个对象，并访问主页
     *
     * @param homepage 主页URL
     */
    public BrowserHistory(String homepage) {
        data[0] = homepage;
        dataLength = 1;
    }

    /**
     * 访问一个网页，在访问的同时会清理掉 大于当前下标位的所有历史访问记录。
     * 从当前的下标开始重新访问一个网页。
     * 当前下标向前移动一位，将URL记录在移动后的位置上，并重新记录dataLength的值位 index+1；
     *
     * @param url 网页的URL
     */
    public void visit(String url) {
        index++;
        data[index] = url;
        dataLength = index + 1;
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);
        return data[index];
    }

    public String forward(int steps) {
        index = Math.min(dataLength - 1, index + steps);
        return data[index];
    }

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("leetcode.com");
        bh.visit("google.com");
        bh.visit("facebook.com");
        bh.visit("youtube.com");
        bh.back(1);
        bh.back(1);
        bh.forward(1);
        bh.visit("linkedin.com");
        bh.forward(2);
        bh.back(2);
        bh.back(7);

    }
}
