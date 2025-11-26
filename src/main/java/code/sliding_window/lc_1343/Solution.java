package code.sliding_window.lc_1343;

/**
 * @author geyan
 * @date 2025/11/26
 */
class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // 入
            int left = i + 1 - k;
            if (left < 0) {
                continue;
            }
            // 更新
            if (sum >= k * threshold) {
                count++;
            }
            // 出
            sum -= arr[left];
        }
        return count;
    }
}

