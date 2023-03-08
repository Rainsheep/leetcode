class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Math.max(i >= 1 ? dp[i - 1] : 0, (i >= 2 ? dp[i - 2] : 0) + nums[i]);
        }
        return dp[n - 1];

    }
}