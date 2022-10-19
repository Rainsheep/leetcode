class Solution {

    public int removeDuplicates(int[] nums) {
        int vailIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[vailIndex]) {
                continue;
            }
            nums[++vailIndex] = nums[i];
        }
        return vailIndex + 1;

    }
}