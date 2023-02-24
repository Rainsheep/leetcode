class Solution {

    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int t = i >= 2 ? dp[i - 2] : 0;
            dp[i] = Math.max(t + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}