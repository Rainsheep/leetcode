class Solution {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums, target, true), find(nums, target, false)};

    }

    private int find(int[] nums, int target, boolean lower) {
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (lower) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                continue;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }

        return ans;
    }
}