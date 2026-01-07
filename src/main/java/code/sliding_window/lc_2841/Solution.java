package code.sliding_window.lc_2841;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author geyan
 * @date 2026/1/4
 */
class Solution {

    public static void main(String[] args) {
        long sum = new Solution().maxSum(List.of(1, 1, 1, 3), 2, 2);
        System.out.println(sum);
    }
    public long maxSum(List<Integer> nums, int m, int k) {
        // Set<Integer> set = new HashSet<>();  不能用Set，否则如上示例，最后一个1就会被删除
        Map<Integer, Integer> map = new HashMap<>();
        long maxSum = 0;
        long sum = 0;
        for (int right = 0; right < nums.size(); right++) {
            sum += nums.get(right);
            map.merge(nums.get(right), 1, Integer::sum);

            int left = right - k + 1;
            if (left < 0) {
                continue;
            }
            // 由于是固定长度的窗口，不存在主动收缩的情况，所以下面是错误的
            // while (set.size() < m) {
            //     // 不符合要求，收缩窗口
            //     left++;
            // }
            if (map.size() >= m) {
                maxSum = Math.max(maxSum, sum);
            }
            sum -= nums.get(left);
            map.merge(nums.get(left), -1, Integer::sum);
            if (map.get(nums.get(left)) == 0) {
                map.remove(nums.get(left));
            }
        }
        return maxSum;
    }
}
