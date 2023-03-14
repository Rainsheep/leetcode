class Solution {

    int target;
    int ans;

    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        ans = 0;
        dfs(nums, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                ans++;
            }
            return;
        }

        int sum1 = sum + nums[index];
        int sum2 = sum - nums[index];
        dfs(nums, index + 1, sum1);
        dfs(nums, index + 1, sum2);
    }
}