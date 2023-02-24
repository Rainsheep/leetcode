class Solution {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(nums[i], min[i - 1] * nums[i]));
        }

        int ans = max[0];
        for (int i : max) {
            ans = Math.max(i, ans);
        }
        return ans;
    }
}
