class Solution {
    public int[] countBits(int n) {
        int len = n + 1;
        int[] nums = new int[len];
        nums[0] = 0;
        int k = 1;
        int r = 0;
        while (k < len) {
            int pow = (int) Math.pow(2, r);
            for (int i = 0; i < pow && k < len; i++) {
                if (i < pow / 2) {
                    nums[k] = nums[k - pow / 2];
                } else {
                    nums[k] = nums[k - pow / 2] + 1;
                }
                k++;
            }
            r++;
        }

        return nums;

    }
}