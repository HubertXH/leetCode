package queuesandstack;

import java.util.Stack;

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
 * 使用两个栈的数据结构来处理：
 * 一个前进的栈 forward 每前进和访问一个元素就向该栈中压入该元素，每前进一步 如果back中有元素则将栈顶的元素出栈，然后将该元素压入forward中。
 * 每访问一个元素 将该元素压入forward中并将back栈中的元素清空。
 * 一个后退栈 back 每当后退时，从forward栈中弹出栈顶元素押入back中。
 * <p>
 * 使用栈来处理，性能不及数组来的好。
 *
 * @author hubert
 */
public class BrowserHistory {

    private Stack<String> forward = new Stack<>();

    private Stack<String> back = new Stack<>();

    public BrowserHistory(String homepage) {
        forward.push(homepage);
    }

    public void visit(String url) {
        forward.push(url);
        back.clear();
    }

    public String back(int steps) {
        int i = 1;
        while (i <= steps && forward.size() > 1) {
            back.push(forward.pop());
            i++;
        }
        return forward.peek();
    }

    public String forward(int steps) {
        int i = 1;
        while (i <= steps && !back.isEmpty()) {
            forward.push(back.pop());
            i++;
        }
        return forward.peek();
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
