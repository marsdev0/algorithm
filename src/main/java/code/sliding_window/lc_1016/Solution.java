package code.sliding_window.lc_1016;

/**
 * @author geyan
 * @date 2026/1/4
 */
class Solution {

    // 这个跟滑动窗口有啥关系？ 直接用contains就行
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String binaryStr = Integer.toBinaryString(i);
            if (!s.contains(binaryStr)) {
                return false;
            }
        }
        return true;
    }
}
