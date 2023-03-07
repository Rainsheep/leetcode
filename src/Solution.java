import java.util.Arrays;

class Solution {

    int[] val;
    int n;
    int[][] cache;

    public int maxCoins(int[] nums) {
        this.n = nums.length + 2;
        val = new int[n];
        System.arraycopy(nums, 0, val, 1, nums.length);
        val[0] = val[n - 1] = 1;

        this.cache = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(0, n - 1);
    }

    private int dfs(int left, int right) {
        if (left >= right - 1) {
            return 0;
        }
        if (cache[left][right] != -1) {
            return cache[left][right];
        }

        for (int i = left + 1; i < right; i++) {
            int sum = val[left] * val[i] * val[right];
            sum += dfs(left, i) + dfs(i, right);
            cache[left][right] = Math.max(cache[left][right], sum);
        }
        return cache[left][right];
    }
}