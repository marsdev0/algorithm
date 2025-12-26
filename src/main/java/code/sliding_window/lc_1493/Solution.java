package code.sliding_window.lc_1493;

/**
 * @author geyan
 * @date 2025/12/26
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,1,0,1};
        int ans = solution.longestSubarray(nums);
        System.out.println(ans);
    }

    // 窗口变大
    // 当满足某个条件时，收缩窗口
    // 更新数据
    public int longestSubarray(int[] nums) {
        int count = 0;
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 1) {
                count++;

                while (count > 1) {
                    if (nums[left] == 0) {
                        count--;
                    }
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}
