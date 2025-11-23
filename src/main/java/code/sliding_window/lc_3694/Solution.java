package code.sliding_window.lc_3694;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 定长滑动窗口问题
 *
 * @author geyan
 * @date 2025/11/23
 */
class Solution {

    Map<Character, int[]> map = new HashMap<>();

    {
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('L', new int[]{-1, 0});
        map.put('R', new int[]{1, 0});
    }

    /**
     * 求不同坐标的数量，那么就是求滑动窗口内的不同偏移量的数量
     */
    public int distinctPoints(String s, int k) {
        Set<String> set = new HashSet<>();
        // 第一个窗口，钦定为(0, 0)，因为具体的数值不重要
        int x = 0, y = 0;
        set.add(x + "_" + y);

        int left = 0;
        int right = k;

        while (right < s.length()) {
            char r = s.charAt(right);
            int[] res = map.get(r);
            x += res[0];
            y += res[1];
            char l = s.charAt(left);
            res = map.get(l);
            // 这是移出l偏移量的影响，所以是减
            x -= res[0];
            y -= res[1];
            set.add(x + "_" + y);
            right++;
            left++;
        }
        return set.size();
    }
}
