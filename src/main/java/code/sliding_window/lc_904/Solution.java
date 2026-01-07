package code.sliding_window.lc_904;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geyan
 * @date 2026/1/3
 */
class Solution {

    // 思路：在滑动过程中，保持窗口内的元素种类不超过2
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> cntMap = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < fruits.length; right++) {
            cntMap.merge(fruits[right], 1, Integer::sum);

            while (cntMap.size() > 2) {
                cntMap.merge(fruits[left], -1, Integer::sum);

                if (cntMap.get(fruits[left]) == 0) {
                    cntMap.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
