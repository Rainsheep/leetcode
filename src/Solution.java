class Solution {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        int ret = len + 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                ret = i + 1;
                break;
            }
        }
        return ret;
    }


    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}