class Solution {

    public void nextPermutation(int[] nums) {
        int index1 = nums.length - 2;
        for (; index1 >= 0; index1--) {
            if (nums[index1] < nums[index1 + 1]) {
                break;
            }
        }

        if (index1 < 0) {
            reverse(nums, 0);
            return;
        }

        int index2 = nums.length - 1;
        while (true) {
            if (nums[index2] > nums[index1]) {
                swap(nums, index2, index1);
                break;
            }
            index2--;
        }

        reverse(nums, index1 + 1);

    }


    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}