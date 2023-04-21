class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int nowMax = 0;
        int nextMax = nums[0];
        for (int i = 0; i < n; i++) {
            if (nowMax >= nums.length - 1) {
                return step;
            }
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == nowMax) {
                step++;
                nowMax = nextMax;
            }

        }
        return step;
    }

    public static void main(String[] args) {
        new Solution().jump(new int[]{1, 1, 1, 1});
    }
}