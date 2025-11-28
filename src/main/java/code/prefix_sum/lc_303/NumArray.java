package code.prefix_sum.lc_303;

/**
 * @author geyan
 * @date 2025/11/28
 */
class NumArray {

    int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    // 数组中的left，right下标对应前缀和数组的下标为left+1, right+1
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}
