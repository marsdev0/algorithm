package code.sliding_window.lc_2875;

/**
 * @author geyan
 * @date 2026/1/8
 */
class Solution {

    // 思路：和等于target = 和大于等于target - 和大于等于target+1，求最短，这个思路是错误的
    // 如果是求个数，可以相减，求最短长度，怎么相减呢
    public int minSizeSubarray(int[] nums, int target) {
        return getMinSIzeSubarrayWithTarget(nums, target);
    }

    // 和大于等于target的最短子数组
    public int getMinSIzeSubarrayWithTarget(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        int minLen = 0x3f3f3f3f;
        int left = 0;

        // 不能只是2，但是也不能无限循环，需要有退出机制，要么就是有一个循环次数
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        // 不能单纯的加1，至少是2
        int k = target / sum  + 10;
        sum = 0;
        for (int right = 0; right < n * k; right++) {
            sum += nums[right % n];
            while (sum >= target) {
                // 已经开始学会在这里判断了
                // 不能思维定式，一定要放在while循环外面判断！！！
                if (sum == target) {
                    minLen = Math.min(minLen, right - left + 1);
                }
                sum -= nums[left % n];
                left++;
            }
        }
        return minLen == 0x3f3f3f3f ? -1 : minLen;
    }
}
