class Solution {

    public int jump(int[] nums) {
        int maxIndex = 0;
        int step = 0;
        int nextMax = 0;
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);

            if (nextMax >= len - 1) {
                return step + 1;
            }

            if (maxIndex == i) {
                maxIndex = nextMax;
                step++;
            }
        }
        return 0;

    }
}