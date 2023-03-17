import java.util.Arrays;

class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        while (right >= 1 && nums[right] >= nums[right - 1]) {
            right--;
        }

        if (left >= right) {
            return 0;
        }

        int[] flag = find(nums, left, right + 1);
        int leftIndex = Arrays.binarySearch(nums, 0, left + 1, flag[0]);
        int rightIndex = Arrays.binarySearch(nums, right, nums.length, flag[1]);

        if (leftIndex < 0) {
            leftIndex = -leftIndex - 1;
        } else {
            while (nums[leftIndex] == nums[leftIndex + 1]) {
                leftIndex++;
            }
            leftIndex++;
        }

        rightIndex = rightIndex < 0 ? -rightIndex - 1 : rightIndex;

        return rightIndex - leftIndex;
    }

    private int[] find(int[] nums, int i, int j) {
        int min = nums[i];
        int max = nums[i];

        for (int k = i; k < j; k++) {
            max = Math.max(nums[k], max);
            min = Math.min(nums[k], min);
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{2, 3, 3, 2, 4}));

    }
}