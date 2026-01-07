package code.sliding_window.lc_1695;

import java.util.HashSet;
import java.util.Set;

/**
 * @author geyan
 * @date 2026/1/4
 */
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        int left = 0;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
