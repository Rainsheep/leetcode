class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count = 1;
                continue;
            }
            count += num == res ? 1 : -1;
        }
        return res;
    }
}