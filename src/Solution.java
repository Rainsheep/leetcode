class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i == 0 ? 1 : (res[i - 1] * nums[i - 1]);
        }

        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = R * res[i];
            R *= nums[i];
        }

        return res;

    }
}