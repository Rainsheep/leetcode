class Solution {

    public int jump(int[] nums) {
        int nowMax = 0;
        int step = 0;
        int nextMax = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (nowMax == i) {
                step++;
                nowMax = nextMax;
            }
        }
        return step;

    }
}