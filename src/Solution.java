class Solution {

    public int maxCoins(int[] nums) {
        int[] val = new int[nums.length + 2];
        System.arraycopy(nums, 0, val, 1, nums.length);
        val[0] = val[val.length - 1] = 1;
        int[][] dp = new int[val.length][val.length];

        for (int i = val.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < val.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], val[k] * val[i] * val[j] + dp[i][k] + dp[k][j]);
                }
            }

        }
        return dp[0][val.length - 1];


    }
}