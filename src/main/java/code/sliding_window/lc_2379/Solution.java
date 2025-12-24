package code.sliding_window.lc_2379;

/**
 * @author geyan
 * @date 2025/12/24
 */
class Solution {

    // 窗口大小为k，找出窗口中白色块的个数，返回最小的那个
    public int minimumRecolors(String blocks, int k) {
        char[] chs = blocks.toCharArray();
        int count = 0;
        int minCount = chs.length;

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'W') {
                count++;
            }
            int left = i+1-k;
            if (left < 0) {
                continue;
            }
            minCount = Math.min(minCount, count);

            if (chs[left] == 'W') {
                count--;
            }
        }
        return minCount;
    }
}
