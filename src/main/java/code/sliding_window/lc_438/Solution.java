package code.sliding_window.lc_438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geyan
 * @date 2026/1/4
 */
class Solution {

    // 思路：窗口大小就是p的长度，只要窗口内的字符与p的字符一样，就可以了
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int[] pNums = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pNums[p.charAt(i)-'a']++;
        }
        List<Integer> ans = new ArrayList<>();

        int[] sNums = new int[26];

        char[] chs = s.toCharArray();
        for (int right = 0; right < chs.length; right++) {
            char c = chs[right];
            sNums[c-'a']++;

            int left = right - k + 1;
            if (left < 0) {
                continue;
            }
            if (check(sNums, pNums)) {
                ans.add(left);
            }
            sNums[chs[left]-'a']--;
            // 不需要你left++，因为这是固定窗口
        }
        return ans;
    }

    boolean check(int[] sNums, int[] pNums) {
        for (int i = 0; i < pNums.length; i++) {
            if (sNums[i] != pNums[i]) {
                return false;
            }
        }
        return true;
    }
}
