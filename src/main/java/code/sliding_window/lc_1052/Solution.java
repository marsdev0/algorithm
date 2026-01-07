package code.sliding_window.lc_1052;

/**
 * @author geyan
 * @date 2026/1/5
 */
class Solution {
    // 思路：统计窗口内老板生气(g[i] == 1)时的客户数量，找到最大的，记为maxSum
    // 然后遍历数组，统计g[0]时的客户端数量 + 前面找到的maxSum
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0 ;
        int maxSum = 0;
        int start = 0;
        for (int right = 0; right < customers.length; right++) {
            if (grumpy[right] == 1) {
                sum += customers[right];
            }
            int left = right - minutes + 1;
            if (left < 0) {
                continue;
            }
            if (sum > maxSum) {
                maxSum = sum;
                start = left;
            }
            if (grumpy[left] == 1) {
                sum -= customers[left];
            }
        }

        sum = 0;
        for (int i = 0; i < customers.length; i++) {
            // if (i >= start && i < start + minutes) {
            //     continue;
            // }
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        sum += maxSum;
        return sum;
    }
}
