class Solution {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int now = 0;
        while (now <= right) {
            if (nums[now] == 0) {
                swap(nums, now, left++);
                now = Math.max(now, left);
            } else if (nums[now] == 2) {
                swap(nums, now, right--);
            } else {
                now++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}