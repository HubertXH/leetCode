package str;

import java.util.HashMap;
import java.util.Map;

/**
 * No:299. Bulls and Cows
 * Medium
 * You are playing the Bulls and Cows game with your friend.
 * <p>
 * You write down a secret number and ask your friend to guess what the number is.
 * When your friend makes a guess, you provide a hint with the following info:
 * <p>
 * The number of "bulls", which are digits in the guess that are in the correct position.
 * The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
 * Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
 * Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
 * <p>
 * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
 * Note that both secret and guess may contain duplicate digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: secret = "1807", guess = "7810"
 * Output: "1A3B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1807"
 *   |
 * "7810"
 * Example 2:
 * <p>
 * Input: secret = "1123", guess = "0111"
 * Output: "1A1B"
 * Explanation: Bulls are connected with a '|' and cows are underlined:
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= secret.length, guess.length <= 1000
 * secret.length == guess.length
 * secret and guess consist of digits only.
 *
 * @author Hubert
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        if (null == secret || null == guess || secret.length() != guess.length()) {
            return "0A0B";
        }
        Map<Character, Integer> charMap = new HashMap<>(secret.length());
        for (int i = 0; i < secret.length(); i++) {
            if (charMap.containsKey(secret.charAt(i))) {
                charMap.put(secret.charAt(i), 0);
            }
            charMap.put(secret.charAt(i), charMap.get(secret.charAt(i)) + 1);
        }
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bulls++;
                charMap.put(guess.charAt(i), charMap.get(guess.charAt(i)) - 1);
            } else if (charMap.containsKey(guess.charAt(i))) {
                cows++;
                charMap.put(guess.charAt(i), charMap.get(guess.charAt(i)) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }
}
