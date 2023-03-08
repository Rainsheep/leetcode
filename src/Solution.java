class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        int[] dpNo1 = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Math.max(i >= 1 ? dp[i - 1] : 0, (i >= 2 ? dp[i - 2] : 0) + nums[i]);
        }
        for (int i = 1; i < n; i++) {
            dpNo1[i] = Math.max(dpNo1[i - 1], (i >= 2 ? dpNo1[i - 2] : 0) + nums[i]);
        }
        boolean selece = dp[n - 1] != dpNo1[n - 1];
        int res = selece ? dp[n - 2] : dp[n - 1];
        return Math.max(res, dpNo1[n - 1]);

    }
}