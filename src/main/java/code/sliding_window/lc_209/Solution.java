package code.sliding_window.lc_209;

/**
 * @author geyan
 * @date 2026/1/7
 */
class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = 0x3f3f3f3f;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                // 不是所有的都必须在while循环外面写的
                // 也可以放到里面做
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == 0x3f3f3f3f ? 0 : minLen;
    }
}
