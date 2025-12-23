package code.sliding_window.lc_395;

/**
 * @author geyan
 * @date 2025/12/23
 */
class Solution {

    public int longestSubstring(String s, int k) {
        char[] chs = s.toCharArray();

        int len = 0;
        for (int i = 1; i <= 26; i++) {
            len = Math.max(len, findCount(chs, k, i));
        }
        return len;
    }

    int findCount(char[] chs, int k, int count) {
        int[] window = new int[26];
        int left = 0;
        int right = 0;
        // 当前窗口中不同字符的种数
        int curCount = 0;
        // 当前窗口中相同字符出现次数不少于k的字符种数
        int valid = 0;
        int res = 0;

        while (right < chs.length) {
            int c = chs[right++] - 'a';
            if (window[c] == 0) {
                // 说明当前窗口没有该字符
                curCount++;
            }
            window[c]++;
            if (window[c] == k) {
                valid++;
            }

            while (curCount > count) {
                int d = chs[left++] - 'a';
                if (window[d] == k) {
                    valid--;
                }
                window[d]--;
                if (window[d] == 0) {
                    curCount--;
                }
                // 不能以小于k判断，会重复计算的，就跟前面添加一样
                // if (window[d] < k) {
                //     valid--;
                // }
            }
            if (valid == count) {
                res = Math.max(res, right - left);
            }
        }
        return res;
    }
}
