package code.sliding_window.lc_1297;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geyan
 * @date 2026/1/5
 */
class Solution {

    // 思路：关键找到是定长窗口，还是不定长窗口问题，定长不需要主动收缩，不定长需要考虑什么时候收缩
    // 这题我理解应该以maxLetters判断
    // 这种写法解决不了 "aaaa", 1, 3, 3 这个入参 debug一下就知道了
    public int maxFreq_error(String s, int maxLetters, int minSize, int maxSize) {
        char[] chs = s.toCharArray();
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        int left = 0;
        for (int right = 0; right < chs.length; right++) {
            char c = chs[right];
            map.merge(c, 1, Integer::sum);
            while (map.size() > maxLetters) {
                map.merge(chs[left], -1, Integer::sum);
                if (map.get(chs[left]) == 0) {
                    map.remove(chs[left]);
                }
                left++;
            }
            int cnt = right - left + 1;
            if (cnt >= minSize && cnt <= maxSize) {
                resultMap.merge(s.substring(left, right + 1), 1, Integer::sum);
            }
        }
        System.out.println(resultMap);
        for (int val : resultMap.values()) {
            maxLen = Math.max(maxLen, val);
        }
        return maxLen;
    }

    // 还是转化成固定窗口，只不过窗口有好几种
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int maxCnt = 0;
        for (int i = minSize; i <= maxSize; i++) {
            maxCnt = Math.max(maxCnt, maxFreq0(s, maxLetters, i));
        }
        return maxCnt;
    }

    int maxFreq0(String s, int maxLetters, int windowSize) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.merge(c, 1, Integer::sum);
            int left = right - windowSize + 1;
            if (left < 0) {
                continue;
            }
            if (map.size() <= maxLetters) {
                // 满足条件
                resultMap.merge(s.substring(left, right + 1), 1, Integer::sum);
            }
            map.merge(s.charAt(left), -1, Integer::sum);
            if (map.get(s.charAt(left)) == 0) {
                map.remove(s.charAt(left));
            }
        }
        int maxLen = 0;
        for (int val : resultMap.values()) {
            maxLen = Math.max(maxLen, val);
        }
        return maxLen;
    }
}
