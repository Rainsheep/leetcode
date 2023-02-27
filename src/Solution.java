import java.util.Random;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int l, int r, int index) {
        int q = randomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        }
        return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
    }

    public int randomPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, i, l);
        return partition(nums, l, r);

    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[l];
        int k = l - 1;
        for (int i = l; i <= r; i++) {
            if (nums[i] <= x) {
                swap(nums, ++k, i);
            }
        }
        swap(nums, k, l);
        return k;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}