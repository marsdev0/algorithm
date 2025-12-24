package code.sliding_window.lc_1423;

/**
 * @author geyan
 * @date 2025/12/24
 */
class Solution {

    // 思路：开头或末尾拿一张牌，那么剩下的肯定是连续的牌
    // 拿k张牌，那么剩下来就是n-k张牌，即题目可以转化为剩下来连续的牌的最小点数
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int m = n - k;

        if (n == k) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += cardPoints[i];
            }
            return sum;
        }


        int sum = 0;
        int minSum = 0x3f3f3f3f;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
            sum += cardPoints[i];
            int left = i + 1 - m;
            if (left < 0) {
                continue;
            }
            minSum = Math.min(minSum, sum);
            sum -= cardPoints[left];
        }
        return totalSum - minSum;
    }
}
