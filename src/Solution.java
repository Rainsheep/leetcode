import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int k = partition(nums, low, high);
            quickSort(nums, low, k - 1);
            quickSort(nums, k + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int random = new Random().nextInt(high - low);
        swap(nums, low, low + random);
        int x = nums[low];
        int k = low - 1;
        for (int i = low; i <= high; i++) {
            if (nums[i] <= x) {
                swap(nums, i, ++k);
            }
        }
        swap(nums, k, low);
        return k;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}