package code.sliding_window.lc_2461;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author geyan
 * @date 2025/12/23
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,1,7,8,9};
        long res = solution.maximumSubarraySum(nums, 3);
        System.out.println(res);
    }

    // 使用Map记录元素出现的次数，如果窗口中的元素互相不同，那么map的大小肯定是等于k的
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 入
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            // 左边界
            int left = i - k + 1;
            if (left < 0) {
                continue;
            }

            // 更新
            if (map.size() == k) {
                // left = 0，表示当前正好是完整的一个窗口，如果此时map大小等于k，表示没有重复元素
                maxSum = Math.max(maxSum, sum);
            }

            // 出
            sum -= nums[left];
            int cnt = map.get(nums[left]);
            if (cnt > 1) {
                map.put(nums[left], cnt-1);
            } else {
                map.remove(nums[left]);
            }
        }
        return maxSum;
    }

    // 前缀和超过限制
    public long maximumSubarraySum_ERROR(int[] nums, int k) {
        long[] preSum = new long[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        long res = 0;
        for (int i = 1; i < preSum.length; i++) {
            int r = i + k - 1;
            if (r < preSum.length) {
                if (check(nums, i-1, r-1)) {
                    res = Math.max(res, preSum[r] - preSum[i-1]);
                }
            }
        }
        return res;
    }

    boolean check(int[] nums, int left, int right) {
        Set<Integer> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }
}
