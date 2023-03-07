class Solution {

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] val = new int[n];
        System.arraycopy(nums, 0, val, 1, nums.length);
        val[0] = val[n - 1] = 1;
        int[][] dp = new int[n][n];
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }

        return dp[0][n - 1];
    }

}