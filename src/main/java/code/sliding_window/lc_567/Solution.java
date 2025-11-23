package code.sliding_window.lc_567;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geyan
 * @date 2025/11/22
 */
class Solution {

    /**
     * 思路：s2中是否存在s1的排列，s1中可能有重复元素，所以需要Map记录每个元素的个数
     */
    public boolean checkInclusion(String s1, String s2) {
        // s1中的元素，key是元素，val是个数
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int count = needMap.getOrDefault(c, 0);
            needMap.put(c, count + 1);
        }

        int left = 0;
        int right = 0;

        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            // 更新数据
            if (needMap.containsKey(c)) {
                if (needMap.get(c).equals(windowMap.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == needMap.size()) {
                    // 找到子串
                    return true;
                }
                char d = s2.charAt(left);
                left++;

                if (needMap.containsKey(d)) {
                    if (needMap.get(d).equals(windowMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }

            }

        }
        return false;
    }
}
