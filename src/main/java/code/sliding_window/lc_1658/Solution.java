package code.sliding_window.lc_1658;

/**
 * @author geyan
 * @date 2026/1/3
 */
class Solution {

    public static void main(String[] args) {
        int ans = new Solution().minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309},
                134365);
        System.out.println(ans);
    }
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int left = 0;
        int target = sum - x;
        if (target < 0) {
            return -1;
        } else if (target == 0) {
            return nums.length;
        }

        sum = 0;
        int maxVal = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                maxVal = Math.max(maxVal, right-left+1);
                System.out.printf("%d - %d\n", left, right);
            }
        }
        return maxVal == 0 ? -1 : nums.length - maxVal;
    }
}
