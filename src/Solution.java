class Solution {

    public void nextPermutation(int[] nums) {
        int start = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                start = i - 1;
                break;
            }
        }
        if (start == -1) {
            reverse(nums, 0);
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[start]) {
                swap(nums, start, i);
                reverse(nums, start + 1);
                return;
            }
        }


    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}