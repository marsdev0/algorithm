package code.sliding_window.lc_3090;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geyan
 * @date 2025/12/26
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.maximumLengthSubstring("bcbbbcba");
        System.out.println(res);
    }

    public int maximumLengthSubstring(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        Map<Character, Integer> countMap = new HashMap<>();

        int maxLen = 0;
        for (int right = 0; right < chs.length; right++) {
            countMap.put(chs[right], countMap.getOrDefault(chs[right], 0) + 1);
            while (countMap.get(chs[right]) > 2) {
                countMap.put(chs[left], countMap.get(chs[left]) - 1);
                if (countMap.get(chs[left]) == 0) {
                    countMap.remove(chs[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
