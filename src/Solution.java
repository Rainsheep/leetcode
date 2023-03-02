class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i] * ans[i - 1];
        }

        int suf = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = (i == 0 ? 1 : ans[i - 1]) * suf;
            suf *= nums[i];
        }
        return ans;
    }
}