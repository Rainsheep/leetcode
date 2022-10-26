class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums, target, true), find(nums, target, false)};
    }

    public int find(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
            }

            if (nums[mid] > target || nums[mid] == target && lower) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return ans;
    }
}