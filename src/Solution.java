class Solution {

    public int maxSubArray(int[] nums) {
        int maxElem = nums[0];
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            maxElem = Math.max(num, maxElem);
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(max, sum);
        }

        return maxElem >= 0 ? max : maxElem;
    }
}
