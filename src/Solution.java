import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, nums.length - k, 0, nums.length);
    }

    private int findKth(int[] num, int k, int l, int r) {
        int index = randomPartition(num, l, r);
        if (index == k) {
            return num[index];
        }
        return k > index ? findKth(num, k, index + 1, r) : findKth(num, k, l, index);
    }

    private int randomPartition(int[] num, int l, int r) {
        int index = new Random().nextInt(r - l) + l;
        swap(num, l, index);
        return partition(num, l, r);
    }

    private int partition(int[] num, int l, int r) {
        int x = num[l];
        int k = l - 1;
        for (int i = l; i < r; i++) {
            if (num[i] <= x) {
                swap(num, ++k, i);
            }
        }
        swap(num, k, l);
        return k;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}