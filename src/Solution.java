import java.util.Arrays;

class Solution {

    public void nextPermutation(int[] nums) {
        int k;
        for (k = nums.length - 1; k > 0; k--) {
            if (nums[k] > nums[k - 1]) {
                break;
            }
        }

        if (k == 0) {
            Arrays.sort(nums);
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[k - 1]) {
                swap(nums, i, k - 1);
                break;
            }
        }
        Arrays.sort(nums, k, nums.length);

    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}