package code.sliding_window.lc_2024;

/**
 * @author geyan
 * @date 2026/1/2
 */
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chs = answerKey.toCharArray();

        int left = 0;
        int right = 0;
        int cntF = 0;
        int cntT = 0;

        int max = 0;

        while (right < chs.length) {
            if (chs[right] == 'T') {
                cntT++;
            }
            if (chs[right] == 'F') {
                cntF++;
            }
//            if (cntT > cntF) {
//                // 以T为准
//                while (cntF > k) {
//                    if (chs[left] == 'F') {
//                        cntF--;
//                    }
//                    left++;
//                }
//            } else {
//                while (cntT > k) {
//                    if (chs[left] == 'T') {
//                        cntT--;
//                    }
//                    left++;
//                }
//            }
//            max = Math.max(max, right-left+1);
//            right++;

            while (cntT > k && cntF > k) {
                if (chs[left] == 'T') {
                    cntT--;
                } else {
                    cntF--;
                }
                left++;
            }
            max = Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}
