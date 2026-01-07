package code.sliding_window.lc_2958;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author geyan
 * @date 2026/1/3
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 1);
        System.out.println(ans);
    }



    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);

            while (map.get(nums[right]) > k) {
                // 移动左指针
                map.merge(nums[left], -1, Integer::sum);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;

            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


//    boolean check(Map<Integer, Integer> map, int k) {
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            if (entry.getValue() > k) {
//                return false;
//            }
//        }
//        return true;
//    }
}
