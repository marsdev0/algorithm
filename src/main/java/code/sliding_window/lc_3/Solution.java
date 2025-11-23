package code.sliding_window.lc_3;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * @author geyan
 * @date 2025/11/22
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                j++;
                set.add(c);
                maxLen = Math.max(maxLen, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
}
