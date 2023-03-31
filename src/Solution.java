class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] >= nums[left] && target >= nums[left] && target <= nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < nums[left] && (target <= nums[mid] || target >= nums[left])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5, 1, 3}, 5));
    }
}