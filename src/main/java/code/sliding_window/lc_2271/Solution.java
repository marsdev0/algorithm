package code.sliding_window.lc_2271;

/**
 * @author geyan
 * @date 2026/1/3
 */
class Solution {

    public static void main(String[] args) {
//        int[][] tiles = {{10,11},{1,1}};
//        int[][] tiles = {{1,5}, {10,11}, {12,18}, {20,25},{30,32}};
        int[][] tiles = {{8051,8057},{8074,8089},{7994,7995},{7969,7987},{8013,8020},{8123,8139},{7930,7950},{7930,7950},{7917,7925},{8027,8035},{8003,8011}};

        int ans = new Solution().maximumWhiteTiles(tiles, 9854);
        System.out.println(ans);
    }
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int max = -0x3f3f3f;
        int min = 0x3f3f3f;

        for (int i = 0; i < tiles.length; i++) {
            min = Math.min(min, tiles[i][0]);
            max = Math.max(max, tiles[i][1]);
        }
        int[] arr = new int[max-min+10];

        for (int i = 0; i < tiles.length; i++) {
            int l = tiles[i][0] - min;
            int r = tiles[i][1] - min;
            for (int j = l; j <= r; j++) {
                arr[j] = 1;
            }
        }

        int res = 0;
        int k = 0;
        while (k < arr.length) {
            if (arr[k] == 1) {
                int right = k;
                while (right < arr.length && arr[right] == 1) {
                    right++;
                }
                res = Math.max(res, right-k);
                k = right;
            }
            k++;
        }
        return res;
    }
}
