package code.two_pointers.lc_1750;

/**
 * @author geyan
 * @date 2025/11/29
 */
class Solution {

    /**
     * 这道题就是删除相同的前后缀
     */
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char cur = s.charAt(left);

            while (left <= right && cur == s.charAt(left)) {
                left++;
            }

            while (left <= right && cur == s.charAt(right)) {
                right--;
            }
        }
        return right - left + 1;
    }
}
