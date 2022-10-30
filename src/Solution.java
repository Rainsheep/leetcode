class Solution {

    public int jump(int[] nums) {
        int step = 0;
        int maxIndex = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if (i == end) {
                end = maxIndex;
                step++;
            }
        }
        return step;
    }
}