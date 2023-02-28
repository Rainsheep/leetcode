import java.util.Random;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int k = randomPartition(nums, l, r);
        if (k == index) {
            return nums[k];
        }
        return k > index ? quickSelect(nums, l, k - 1, index) : quickSelect(nums, k + 1, r, index);
    }

    private int randomPartition(int[] nums, int l, int r) {
        int randomIndex = new Random().nextInt(r - l + 1) + l;
        swap(nums, randomIndex, l);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int x = nums[l];
        int mid = l - 1;
        for (int i = l; i <= r; i++) {
            if (nums[i] <= x) {
                swap(nums, ++mid, i);
            }
        }
        swap(nums, l, mid);

        return mid;
    }


    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}