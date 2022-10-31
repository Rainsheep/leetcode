class Solution {

    public int jump(int[] nums) {
        // 现在的步数
        int step = 0;
        // 这一步的最远距离
        int end = 0;
        // 下一步的最远距离
        int maxIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == end) {
                end = maxIndex;
                step++;
            }
        }
        return step;
    }
}