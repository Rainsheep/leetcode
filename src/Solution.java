class Solution {

    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len < 2) {
                nums[len++] = nums[i];
                continue;
            }

            if (nums[i] == nums[len - 2]) {
                continue;
            }
            nums[len++] = nums[i];
        }
        return len;

    }
}