class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{fun(nums, target, true), fun(nums, target, false)};

    }

    public int fun(int[] nums, int target, boolean isLower) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                if (isLower) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (isLower) {
            return left < nums.length && nums[left] == target ? left : -1;
        } else {
            return right >= 0 && nums[right] == target ? right : -1;
        }
    }
}