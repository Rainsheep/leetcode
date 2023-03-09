class Solution {
    public int[] countBits(int num) {
        int[] nums = new int[num + 1];

        for (int i = 1; i < num + 1; i++) {
            nums[i] = nums[i >> 1] + (i & 1);
        }

        return nums;

    }
}