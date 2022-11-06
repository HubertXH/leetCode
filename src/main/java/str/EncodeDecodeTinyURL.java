package str;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 535
 * <p>
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeDecodeTinyURL {

    private static final Map<String, String> urlMappingMap = new HashMap<>();

    private static final Map<String, String> reversalMappingMap = new HashMap<>();

    private static final String tempStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String baseHost = "http://tinyurl.com/";

    public static void main(String[] args) {
        String[] urls = {"http://finance.sina.com.cn/jjxw/2022-10-08/doc-imqqsmrp1863791.shtml", "https://store.google.com/ca/?hl=en-GB&pli=1", "https://store.google.com/ca/?hl=en-GB&pli=1"};
        for (String url : urls) {
            String shortUrl = encode(url);
            System.out.println(shortUrl);
            System.out.println(decode(shortUrl));
            System.out.println("------------------------------------------------");
        }
    }

    public static String encode(String longUrl) {
        if (StringUtils.isBlank(longUrl)) {
            return StringUtils.EMPTY;
        }
        if (urlMappingMap.containsKey(longUrl)) {
            return baseHost + urlMappingMap.get(longUrl);
        }
        String shortKey = "";
        while (StringUtils.isBlank(shortKey) || reversalMappingMap.containsKey(shortKey)) {
            shortKey = generatorShotKey();
        }
        reversalMappingMap.put(shortKey, longUrl);
        urlMappingMap.put(longUrl, shortKey);
        return baseHost + shortKey;
    }

    private static String generatorShotKey() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < 6; index++) {
            int charIndex = RandomUtils.nextInt(0, tempStr.length());
            stringBuilder.append(tempStr.charAt(charIndex));
        }
        return stringBuilder.toString();
    }

    public static String decode(String shortUrl) {
        String shortKey = StringUtils.substring(shortUrl, baseHost.length());
        return reversalMappingMap.getOrDefault(shortKey, StringUtils.EMPTY);
    }
}
