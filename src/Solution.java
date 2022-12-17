class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 != 0) {
            return findIndex(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            int val1 = findIndex(nums1, 0, nums2, 0, len / 2);
            int val2 = findIndex(nums1, 0, nums2, 0, len / 2 + 1);
            return (val1 + val2) / 2.0;
        }

    }

    public int findIndex(int[] num1, int num1BeginIndex, int[] num2, int num2BeginIndex, int k) {
        if (num1BeginIndex == num1.length) {
            return num2[num2BeginIndex + k - 1];
        }
        if (num2BeginIndex == num2.length) {
            return num1[num1BeginIndex + k - 1];
        }

        if (k == 1) {
            return Math.min(num1[num1BeginIndex], num2[num2BeginIndex]);
        }

        int index1 = Math.min(num1BeginIndex + k / 2 - 1, num1.length - 1);
        int index2 = Math.min(num2BeginIndex + k / 2 - 1, num2.length - 1);
        if (num1[index1] <= num2[index2]) {
            k -= index1 + 1 - num1BeginIndex;
            num1BeginIndex = index1 + 1;
        } else {
            k -= index2 + 1 - num2BeginIndex;
            num2BeginIndex = index2 + 1;
        }
        return findIndex(num1, num1BeginIndex, num2, num2BeginIndex, k);
    }


    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{4, 5, 6};
        System.out.println(new Solution().findIndex(num1, 0, num2, 0, 4));
    }
}