package code.sliding_window.lc_643;

/**
 * @author geyan
 * @date 2025/11/24
 */
class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int maxSum = -0x3f3f3f3f;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int left = i + 1 - k;
            if (left < 0) {
                continue;
            }
            maxSum = Math.max(maxSum, sum);
            sum -= nums[left];
        }

        return maxSum * 1.0 / k;
    }
}
