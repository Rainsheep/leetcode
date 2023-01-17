import java.util.Arrays;

class Solution {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }

        if (k == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i = nums.length - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
                break;
            }
        }

        Arrays.sort(nums, k + 1, nums.length);
    }
}