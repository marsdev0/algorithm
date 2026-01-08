package code.sliding_window.lc_2653;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author geyan
 * @date 2026/1/8
 */
class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int right = 0; right < n; right++) {
            map.merge(nums[right], 1, Integer::sum);

            int left = right - k + 1;
            if (left < 0) {
                continue;
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int val = entry.getKey();
                int freq = entry.getValue();
                if (count + freq >= x) {
                    // 由于map是从小到大排序的，因此当第一次出现count+freq大于等于x时，第x小的元素就是val
                    ans[index++] = Math.min(val, 0);
                    break;
                }
                count += freq;
            }
            map.merge(nums[left], -1, Integer::sum);
            if (map.get(nums[left]) == 0) {
                map.remove(nums[left]);
            }
        }
        return ans;
    }
}
