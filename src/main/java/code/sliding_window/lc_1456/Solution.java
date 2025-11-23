package code.sliding_window.lc_1456;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 定长的滑动窗口
 *
 * @author geyan
 * @date 2025/11/23
 */
class Solution {

    int maxLen = 0;
    int curCount = 0;

    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                curCount++;
            }
            maxLen = Math.max(maxLen, curCount);
            int left = i + 1 - k;
            if (left < 0) {
                continue;
            }
            if (set.contains(s.charAt(left))) {
                curCount--;
            }
        }
        return maxLen;
    }
}
