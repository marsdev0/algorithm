package code.sliding_window.lc_930;

/**
 * @author geyan
 * @date 2026/1/7
 */
class Solution {

    // 不知道子数组的大小，所以很难直接使用滑动窗口
    // 转化成 和>= goal的子数组以及和>=goal+1的子数组  这个不行，没法收缩啊，可以收缩的！！！
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums, goal) - count(nums, goal+1);
    }

    // 和 >= target
    public int count(int[] nums, int target) {
        // 子数组的个数
        if (target <= 0) {
            return nums.length * (nums.length+1) / 2;
        }
        int sum = 0;
        int left = 0;
        int cnt = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                left++;
            }
            // cnt++;
            // 以[0, left-1]开头的子数组都满足sum >= target
            cnt += left;
        }
        return cnt;
    }
}
