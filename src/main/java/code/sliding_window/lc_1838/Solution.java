package code.sliding_window.lc_1838;

import java.util.Arrays;

/**
 * @author geyan
 * @date 2026/1/7
 */
class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 可能长度很长
            long cost = (nums[right] * (long) (right - left + 1)) - sum;
            while (cost > k) {
                // 收缩窗口
                sum -= nums[left];
                left++;
                cost = nums[right] * (right - left + 1) - sum;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
