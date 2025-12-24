package code.sliding_window.lc_2090;

import java.util.Arrays;

/**
 * @author geyan
 * @date 2025/12/24
 */
class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{7,4,3,9,1,8,5,2,6};
        int[] res = solution.getAverages(nums, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    // 本题相当于一个长度为2*k+1的窗口
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);

        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 入
            sum += nums[i];
            if (i < 2 * k) {
                continue;
            }
            // 更新
            ans[i-k] = (int) (sum / (2*k+1));
            // 出
            sum -= nums[i-2*k];
        }
        return ans;
    }

    // 写法不好看
    public int[] getAverages_2(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < k || i > n-1-k) {
                ans[i] = -1;
            }
        }
        // 必须把int改成long
        long sum = 0;
        for (int i = 0; i < k*2+1 && i < n; i++) {
            sum += nums[i];
        }
        for (int i = k; i <= n-1-k; i++) {
            if (i > k) {
                sum += nums[i+k];
            }
            ans[i] = (int) (sum / (2*k+1));
            sum -= nums[i-k];
        }
        return ans;
    }
}
