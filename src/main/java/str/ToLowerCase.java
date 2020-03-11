package str;

import org.apache.commons.lang3.StringUtils;

/**
 * 709
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class ToLowerCase {

    public String solution(String str) {

        if (null == str || str.length() <= 0) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                result.append(Character.toLowerCase(str.charAt(i)));
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

}
