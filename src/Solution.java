import java.util.Arrays;

class Solution {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i + 1, nums.length);
                    return;
                }

            }
        }
        reverse(nums);
    }

    public void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}