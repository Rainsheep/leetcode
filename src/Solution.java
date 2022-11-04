class Solution {

    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        // next step end index
        int max = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }

        }
        return step;
    }

    public static void main(String[] args) {
        new Solution().jump(new int[]{1, 1, 1, 1});
    }
}