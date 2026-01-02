package code.sliding_window.lc_3634;

import java.util.Arrays;

/**
 * @author geyan
 * @date 2026/1/2
 */
class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 如果nums[right]不符合要求，那么nums[right]后面的都不可能符合要求，因为后面的都比nums[right]大
            while (nums[right] > (long) nums[left] * k) {
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return nums.length - max;
    }
}
