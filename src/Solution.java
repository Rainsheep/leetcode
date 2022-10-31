class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findIndex(nums, target, false), findIndex(nums, target, true)};

    }

    public int findIndex(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
            }

            if (nums[mid] < target || nums[mid] == target && lower) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}