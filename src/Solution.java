class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                break;
            }
        }
        if (left == -1) {
            return 0;
        }

        int right = -1;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                right = i;
                break;
            }
        }

        int min = left;
        int max = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        int leftIndex = left;

        for (int i = left; i >= 0; i--) {
            if (nums[i] > nums[min]) {
                leftIndex--;
            } else {
                break;
            }
        }

        int rightIndex = right;
        for (int i = right; i < length; i++) {
            if (nums[i] < nums[max]) {
                rightIndex++;
            } else {
                break;
            }
        }

        return rightIndex - leftIndex + 1;
    }


}