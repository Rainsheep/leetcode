import java.util.Arrays;

class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }
        if (right == 0) {
            return 0;
        }

        int[] target = find(nums, left, right + 1);

        int index1 = Arrays.binarySearch(nums, 0, left + 1, target[0]);
        if (index1 >= 0) {
            while (nums[index1] == nums[index1 + 1]) {
                index1++;
            }
            index1++;
        } else {
            index1 = -index1 - 1;
        }

        int index2 = Arrays.binarySearch(nums, right, nums.length, target[1]);
        index2 = index2 >= 0 ? index2 - 1 : -index2 - 2;
        return index2 - index1 + 1;
    }

    private int[] find(int[] nums, int start, int end) {
        int min = nums[start];
        int max = min;
        for (int i = start; i < end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{2, 3, 3, 2, 4}));

    }
}