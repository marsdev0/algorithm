package code.sliding_window.lc_1004;

/**
 * @author geyan
 * @date 2026/1/4
 */
class Solution {

    // 思路：窗口内最多可以有k个0，那只要记录窗口内0的个数即可，当超过k时，收缩窗口
    public int longestOnes(int[] nums, int k) {
        int cnt = 0;  // 记录窗口内0的个数
        int left = 0;

        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (nums[left] == 0) {
                    cnt--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
