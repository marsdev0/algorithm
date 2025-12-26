package code.hash.lc_594;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geyan
 * @date 2025/12/26
 */
class Solution {

    // 将元素都保存到Map中，假设x是map中，判断x+1是否在
    public int findLHS(int[] nums) {
        // key：元素，val：出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int maxLen = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int x = entry.getKey();
            int cnt = entry.getValue();
            if (map.containsKey(x+1)) {
                maxLen = Math.max(maxLen, cnt + map.get(x+1));
            }
        }
        return maxLen;
    }
}
